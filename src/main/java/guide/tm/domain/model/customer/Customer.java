package guide.tm.domain.model.customer;

/**
 * 顧客
 */
public class Customer {
    CustomerId customerId;
    CustomerName name;
    CustomerName nameKana;
    public Customer() {
        this(new CustomerId(), new CustomerName(), new CustomerName());
    }

    public Customer(CustomerId customerId, CustomerName name, CustomerName nameKana) {
        this.customerId = customerId;
        this.name = name;
        this.nameKana = nameKana;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public CustomerName name() {
        return name;
    }

    public boolean isSame(Customer other) {
        return customerId.isSame(other.customerId);
    }
}
