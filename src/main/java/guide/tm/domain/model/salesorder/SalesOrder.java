package guide.tm.domain.model.salesorder;

import guide.tm.domain.model.customer.Customer;

/**
 * 受注
 */
public class SalesOrder {
    Customer customer;
    OrderedDate orderedDate;

    @Deprecated(since = "for mybatis")
    SalesOrder() {
        this(new Customer(), new OrderedDate());
    }

    public SalesOrder(Customer customer, OrderedDate orderedDate) {
        this.customer = customer;
        this.orderedDate = orderedDate;
    }
}
