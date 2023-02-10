package guide.tm.domain.model.salesorder.content;

import guide.tm.domain.model.customer.Customer;
import jakarta.validation.constraints.AssertFalse;

/**
 * 受注
 */
public class SalesOrderContent {
    Customer customer;
    OrderedDate orderedDate;

    public SalesOrderContent() {
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

    @AssertFalse(message = "顧客名称を入力してください")
    boolean isCustomerEmpty() {
        return customer.code().isEmpty();
    }

    @AssertFalse(message = "受注日を入力してください")
    boolean isOrderedDateEmpty() {
        return orderedDate.isEmpty();
    }
}
