package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.Customers;

import java.util.List;

/**
 * 受注サマリーのリスト
 */
public class SalesOrderSummaries {
    List<SalesOrderSummary> list;

    public SalesOrderSummaries(List<SalesOrderSummary> list) {
        this.list = list;
    }

    public List<SalesOrderSummary> list() {
        return list;
    }

    public Customers customers() {
        return new Customers(list.stream().map(SalesOrderSummary::customer).toList());
    }

    public SalesOrderSummaries of(Customer customer) {
        return new SalesOrderSummaries(
                list.stream()
                        .filter(salesOrderSummary -> salesOrderSummary.customer().isSame(customer))
                        .toList());
    }
}
