package guide.tm.domain.model.customer;

/**
 * 顧客サマリー
 */
public class CustomerSummary {
    CustomerId code;
    CustomerName name;
    CustomerName nameKana;

    @Deprecated CustomerSummary() {
    }

    public CustomerSummary(CustomerId code, CustomerName name, CustomerName nameKana) {
        this.code = code;
        this.name = name;
        this.nameKana = nameKana;
    }

    public CustomerId code() {
        return code;
    }

    public CustomerName name() {
        return name;
    }
}

