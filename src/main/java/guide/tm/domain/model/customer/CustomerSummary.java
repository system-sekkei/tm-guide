package guide.tm.domain.model.customer;

/**
 * 顧客サマリー
 */
public class CustomerSummary {
    CustomerId customerId;
    CustomerName name;
    CustomerName nameKana;

    @Deprecated CustomerSummary() {
    }

    public CustomerSummary(CustomerId customerId, CustomerName name, CustomerName nameKana) {
        this.customerId = customerId;
        this.name = name;
        this.nameKana = nameKana;
    }

    public CustomerId code() {
        return customerId;
    }

    public CustomerName name() {
        return name;
    }
}

