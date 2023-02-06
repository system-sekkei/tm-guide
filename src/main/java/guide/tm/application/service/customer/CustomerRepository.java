package guide.tm.application.service.customer;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerSummaries;

public interface CustomerRepository {
    void register(Customer customer);

    CustomerSummaries summaries();
}
