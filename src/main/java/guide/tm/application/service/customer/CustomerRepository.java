package guide.tm.application.service.customer;

import guide.tm.domain.model.customer.Customer;

public interface CustomerRepository {
    void register(Customer customer);
}
