package guide.tm.domain.model.customer;

import java.util.List;

/**
 * 顧客リスト
 */
public class CustomerSummaries {
    List<CustomerSummary> list;

    public CustomerSummaries(List<CustomerSummary> list) {
        this.list = list;
    }

    public List<CustomerSummary> list() {
        return list;
    }
}
