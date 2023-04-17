package guide.tm.application.service.customer;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.customer.CustomerSearchCriteria;
import guide.tm.domain.model.customer.CustomerSummaries;

public interface CustomerRepository {
    CustomerId register(Customer customer);

    CustomerSummaries summaries();

    CustomerSummaries customerSummariesOf(CustomerSearchCriteria customerSearchCriteria);

    Customer customerOf(CustomerId customerId);
}
