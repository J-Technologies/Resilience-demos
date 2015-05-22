package nl.ordina.hystrix.boundary;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import nl.ordina.hystrix.control.BicService;
import nl.ordina.hystrix.entity.Account;

public class BicValidationCommand extends HystrixCommand<Boolean> {
    private final Account account;
    private final BicService service;

    public BicValidationCommand(Account account, BicService service) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("bic")));
        this.account = account;
        this.service = service;
    }

    @Override
    protected Boolean run() throws Exception {
        return service.isValid(account);
    }   
}