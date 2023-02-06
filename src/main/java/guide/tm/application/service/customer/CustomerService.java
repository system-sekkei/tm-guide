package guide.tm.application.service.customer;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerSummaries;
import org.springframework.stereotype.Service;

/**
 * 顧客サービス
 */
@Service
public class CustomerService {
    CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * 顧客を登録する
     */
    public void register(Customer customer) {
        customerRepository.register(customer);
    }

    public CustomerSummaries customerSummaries() {
        return customerRepository.summaries();
    }
}
