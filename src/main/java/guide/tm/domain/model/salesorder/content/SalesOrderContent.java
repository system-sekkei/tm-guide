package guide.tm.domain.model.salesorder.content;

import guide.tm.domain.model.customer.Customer;

/**
 * 受注
 */
public class SalesOrderContent {
    Customer customer;
    OrderedDate orderedDate;

    @Deprecated(since = "for mybatis")
    SalesOrderContent() {
        this(new Customer(), new OrderedDate());
    }

    public SalesOrderContent(Customer customer, OrderedDate orderedDate) {
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
