package nl.ordina.hystrix.control;

import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import nl.ordina.hystrix.entity.Account;

@Stateless
public class BicService {
    private static final Logger LOG = Logger.getLogger(BicService.class.getName());
    private static final DynamicLongProperty LATENCY
            = DynamicPropertyFactory.getInstance().getLongProperty("bic.latency", 100);

    public boolean isValid(Account account) {
        LOG.info(String.format("Validating BIC with latency %d", LATENCY.get()));
        addLatency(LATENCY.get());
        return !account.getBic().equals("BRBANK");  // Bankrupt bank
    }

    private void addLatency(long latency) {
        try {
            Thread.sleep(latency);
        } catch (InterruptedException ex) {
            Logger.getLogger(BicService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}