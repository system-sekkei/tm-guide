package guide.tm.domain.model.salesorder.content;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse;

/**
 * 受注
 */
public class SalesOrderContent {
    SalesOrderNumber salesOrderNumber;
    Customer customer;
    OrderedDate orderedDate;
    @Valid
    ShippingAddress shippingAddress;

    public SalesOrderContent() {
        this(new SalesOrderNumber(), new Customer(), new OrderedDate(), new ShippingAddress());
    }

    public SalesOrderContent(SalesOrderNumber salesOrderNumber, Customer customer, OrderedDate orderedDate, ShippingAddress shippingAddress) {
        this.salesOrderNumber = salesOrderNumber;
        this.customer = customer;
        this.orderedDate = orderedDate;
        this.shippingAddress = shippingAddress;
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

    public ShippingAddress shippingAddress() {
        return shippingAddress;
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
