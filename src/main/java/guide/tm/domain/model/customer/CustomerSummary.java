package guide.tm.domain.model.customer;

/**
 * 顧客サマリー
 */
public class CustomerSummary {
    CustomerId customerId;
    CustomerNumber customerNumber;
    Name name;
    String personInCharge;

    @Deprecated CustomerSummary() {
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Name name() {
        return name;
    }

    public CustomerNumber customerNumber() {
        return customerNumber;
    }

    public String personInCharge() {
        return personInCharge;
    }
}

