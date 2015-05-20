package nl.ordina.hystrix.boundary;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.logging.Logger;
import nl.ordina.hystrix.control.IbanService;
import nl.ordina.hystrix.entity.Account;

public class IbanValidationCommand extends HystrixCommand<Boolean> {
    private static final Logger LOG = Logger.getLogger(AccountsResource.class.getName());
    private static final String HYSTRIX_GROUP_IBAN = "iban";
    
    private final Account account;
    private final IbanService service;

    public IbanValidationCommand(Account account, IbanService service) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HYSTRIX_GROUP_IBAN)));
        this.account = account;
        this.service = service;
    }

    @Override
    protected Boolean run() throws Exception {
        return service.isValid(account);
    }
}