package guide.tm.domain.model.customer;

/**
 * 顧客
 */
public class Customer {
    CustomerId customerId;
    CustomerName name;
    CustomerName nameKana;
    CustomerType type;

    public Customer() {
        this(new CustomerId(), new CustomerName(), new CustomerName() ,CustomerType.個人);
    }

    public Customer(CustomerId customerId, CustomerName name, CustomerName nameKana, CustomerType type) {
        this.customerId = customerId;
        this.name = name;
        this.nameKana = nameKana;
        this.type = type;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public CustomerName name() {
        return name;
    }

    public CustomerType type() {
        return type;
    }

    public boolean isSame(Customer other) {
        return customerId.isSame(other.customerId);
    }
}
