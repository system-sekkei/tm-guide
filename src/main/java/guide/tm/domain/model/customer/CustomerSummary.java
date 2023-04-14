package guide.tm.domain.model.customer;

/**
 * 顧客サマリー
 */
public class CustomerSummary {
    CustomerId customerId;
    Name name;
    Name nameKana;

    @Deprecated CustomerSummary() {
    }

    public CustomerSummary(CustomerId customerId, Name name, Name nameKana) {
        this.customerId = customerId;
        this.name = name;
        this.nameKana = nameKana;
    }

    public CustomerId code() {
        return customerId;
    }

    public Name name() {
        return name;
    }
}

