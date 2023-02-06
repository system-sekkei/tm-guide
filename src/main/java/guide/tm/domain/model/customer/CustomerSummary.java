package guide.tm.domain.model.customer;

/**
 * 顧客サマリー
 */
public class CustomerSummary {
    CustomerNumber code;
    CustomerName name;

    @Deprecated CustomerSummary() {
    }

    public CustomerSummary(CustomerNumber code, CustomerName name) {
        this.code = code;
        this.name = name;
    }

    public CustomerNumber code() {
        return code;
    }

    public CustomerName name() {
        return name;
    }
}

