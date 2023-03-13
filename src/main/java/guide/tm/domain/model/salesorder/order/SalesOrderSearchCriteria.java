package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.salesorder.content.OrderedDate;

/**
 * 受注検索条件
 */
public class SalesOrderSearchCriteria {
    OrderedDate from;
    OrderedDate to;
    String customerName;

    public SalesOrderSearchCriteria() {
        from = new OrderedDate();
        to = new OrderedDate();
        customerName = "";
    }

    public OrderedDate from() {
        return from;
    }

    public OrderedDate to() {
        return to;
    }

    public String customerName() {
        return customerName;
    }
}
