package guide.tm.domain.model.customer;

/**
 * 顧客
 */
public class Customer {
    CustomerNumber code;
    CustomerName name;
    CustomerType type;

    public Customer() {
        this(new CustomerNumber(), new CustomerName(), CustomerType.個人);
    }

    public Customer(CustomerNumber code, CustomerName name, CustomerType type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public CustomerNumber code() {
        return code;
    }

    public CustomerName name() {
        return name;
    }

    public CustomerType type() {
        return type;
    }
}
