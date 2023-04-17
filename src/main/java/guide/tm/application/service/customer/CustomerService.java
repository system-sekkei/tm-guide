package guide.tm.application.service.customer;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.customer.CustomerSearchCriteria;
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
    public CustomerId register(Customer customer) {
        return customerRepository.register(customer);
    }

    /**
     * 顧客一覧を取得する
     */
    public CustomerSummaries customerSummaries() {
        return customerRepository.summaries();
    }

    /**
     * 顧客を検索する
     */
    public CustomerSummaries customerSummaries(CustomerSearchCriteria customerSearchCriteria) {
        return customerRepository.customerSummariesOf(customerSearchCriteria);
    }

    /**
     * 顧客を取得する
     */
    public Customer customerOf(CustomerId customerId) {
        return customerRepository.customerOf(customerId);
    }
}
