package guide.tm.application.setup;

import guide.tm.application.service.customer.CustomerService;
import guide.tm.domain.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class 顧客準備 {
    @Autowired
    CustomerService customerService;

    public void 顧客のテストデータの準備(Customer 顧客) {
        customerService.register(顧客);
    }
}
