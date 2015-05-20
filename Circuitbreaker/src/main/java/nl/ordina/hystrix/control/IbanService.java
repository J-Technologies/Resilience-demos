package nl.ordina.hystrix.control;

import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.ejb.Stateless;
import nl.ordina.hystrix.entity.Account;

@Stateless
public class IbanService {
    private static final Logger LOG = Logger.getLogger(IbanService.class.getName());
    private static final DynamicLongProperty LATENCY = 
            DynamicPropertyFactory.getInstance().getLongProperty("iban.latency", 100);

    private static final String IBAN_REGEX = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}";
    
    public boolean isValid(Account account) {
        LOG.info(String.format("Validating IBAN with latency %d", LATENCY.get()));
        addLatency(LATENCY.get());
        return Pattern.compile(IBAN_REGEX).matcher(account.getIban()).matches();
    }
    
    private void addLatency(long latency) {
        try {
            Thread.sleep(latency);
        } catch (InterruptedException ex) {
            Logger.getLogger(IbanService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}