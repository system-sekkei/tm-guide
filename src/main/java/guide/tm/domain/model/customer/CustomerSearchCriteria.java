package guide.tm.domain.model.customer;

/**
 * 顧客検索条件
 */
public class CustomerSearchCriteria {
    String customerName;

    public CustomerSearchCriteria() {
    }

    public CustomerSearchCriteria(String customerName) {
        this.customerName = customerName;
    }
}

//public record CustomerSearchCriteria(String customerName) {
//}