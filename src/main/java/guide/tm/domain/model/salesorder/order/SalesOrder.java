package guide.tm.domain.model.salesorder.order;

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

    public Customer customer() {
        return customer;
    }

    public OrderedDate orderedDate() {
        return orderedDate;
    }
}
