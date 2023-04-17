package guide.tm.infrastructure.datasource.customer;

import guide.tm.application.service.customer.CustomerRepository;
import guide.tm.domain.model.customer.*;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDataSource implements CustomerRepository {

    CustomerMapper customerMapper;

    CustomerDataSource(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerId register(Customer customer) {
        CustomerId customerId = CustomerId.newId();
        CustomerNumber customerNumber = new CustomerNumber(String.valueOf(customerMapper.newCustomerNumber()));
        customerMapper.register(customer, customerId, customerNumber);
        customerMapper.registerContact(customer, customerId);
        return customerId;
    }

    @Override
    public CustomerSummaries summaries() {
        return new CustomerSummaries(customerMapper.summaries());
    }

    @Override
    public CustomerSummaries customerSummariesOf(CustomerSearchCriteria customerSearchCriteria) {
        return new CustomerSummaries(customerMapper.customerSummariesOf(customerSearchCriteria));
    }

    @Override
    public Customer customerOf(CustomerId customerId) {
        return customerMapper.customerOf(customerId);
    }
}
