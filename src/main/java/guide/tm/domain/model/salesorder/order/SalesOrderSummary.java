package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.salesorder.content.OrderedDate;

/**
 * 受注サマリー
 */
public class SalesOrderSummary {

    SalesOrderId salesOrderId;
    SalesOrderNumber salesOrderNumber;
    Customer customer;
    OrderedDate orderedDate;

    public SalesOrderId salesOrderId() {
        return salesOrderId;
    }

    public SalesOrderNumber salesOrderNumber() {
        return salesOrderNumber;
    }

    public Customer customer() {
        return customer;
    }

    public OrderedDate orderedDate() {
        return orderedDate;
    }
}
