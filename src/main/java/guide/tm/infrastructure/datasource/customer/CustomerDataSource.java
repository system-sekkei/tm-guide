package guide.tm.infrastructure.datasource.customer;

import guide.tm.application.service.customer.CustomerRepository;
import guide.tm.domain.model.customer.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDataSource implements CustomerRepository {

    CustomerMapper customerMapper;

    CustomerDataSource(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public void register(Customer customer) {
        customerMapper.register(customer);
    }
}
