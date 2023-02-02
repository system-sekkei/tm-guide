package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.customer.Customer;

/**
 * 受注サマリー
 */
public class SalesOrderSummary {

    SalesOrderNumber salesOrderNumber;
    Customer customer;
    OrderedDate orderedDate;

//    @Deprecated(since = "for mybatis")
//    SalesOrderSummary() {
//        this(new Customer(), new OrderedDate());
//    }
//
//    public SalesOrderSummary(Customer customer, OrderedDate orderedDate) {
//        this.customer = customer;
//        this.orderedDate = orderedDate;
//    }


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
