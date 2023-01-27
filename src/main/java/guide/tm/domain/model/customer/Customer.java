package guide.tm.domain.model.customer;

/**
 * 顧客
 */
public class Customer {
    CustomerCode code;
    CustomerName name;
    CustomerType type;

    public Customer() {
        this(new CustomerCode(), new CustomerName(), CustomerType.個人);
    }

    public Customer(CustomerCode code, CustomerName name, CustomerType type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }

}
