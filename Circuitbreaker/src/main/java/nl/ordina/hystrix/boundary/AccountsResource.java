package nl.ordina.hystrix.boundary;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nl.ordina.hystrix.control.BicService;
import nl.ordina.hystrix.control.IbanService;
import nl.ordina.hystrix.entity.Account;

@Path("accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class AccountsResource {
    private static final Logger LOG = Logger.getLogger(AccountsResource.class.getName());
    
    @Inject
    private BicService bicService;
    @Inject
    private IbanService ibanService;
    
    @GET
    public Response ping() {
        return Response.status(Response.Status.OK).entity("Pong").build();
    }

    @POST
    @Path("bic")
    public Response validateBic(Account account) {
        LOG.info(String.format("Validating BIC for %s", account));
        
        if (!bicService.isValid(account))
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("x-validation-error", String.format("%s is not a valid BIC", account.getBic()))
                    .build();
        
        return Response.status(Response.Status.OK).entity("Bic validated successfully").build();
    }
    
    @POST
    @Path("iban")
    public Response validateIban(Account account) {
        LOG.info(String.format("Validating IBAN with hystrix for %s", account));
        
        try {
            if (!new IbanValidationCommand(account, ibanService).execute()) 
                return Response.status(Response.Status.BAD_REQUEST)
                    .header("x-validation-error", String.format("%s is not a valid IBAN", account.getIban()))
                    .build();
            
            return Response.status(Response.Status.OK).entity("Iban validated successfully").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                .entity(e.getCause().getMessage())
                .build();
        }
    }
}