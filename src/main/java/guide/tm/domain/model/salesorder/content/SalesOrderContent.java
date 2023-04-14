package guide.tm.domain.model.salesorder.content;

import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.customer.CustomerName;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse;

/**
 * 受注
 */
public class SalesOrderContent {
    SalesOrderNumber salesOrderNumber;
    CustomerId customerId;
    CustomerName customerName;
    OrderedDate orderedDate;
    @Valid
    ShippingAddress shippingAddress;

    public SalesOrderContent() {
        this(new SalesOrderNumber(), new CustomerId(), new CustomerName(), new OrderedDate(), new ShippingAddress());
    }

    public SalesOrderContent(
            SalesOrderNumber salesOrderNumber,
            CustomerId customerId,
            CustomerName customerName,
            OrderedDate orderedDate,
            ShippingAddress shippingAddress) {
        this.salesOrderNumber = salesOrderNumber;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderedDate = orderedDate;
        this.shippingAddress = shippingAddress;
    }

    public SalesOrderNumber salesOrderNumber() {
        return salesOrderNumber;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public CustomerName customerName() {
        return customerName;
    }

    public OrderedDate orderedDate() {
        return orderedDate;
    }

    public ShippingAddress shippingAddress() {
        return shippingAddress;
    }

    @AssertFalse(message = "顧客を選択してください")
    boolean isCustomerEmpty() {
        return customerId.isEmpty();
    }

    @AssertFalse(message = "受注日を入力してください")
    boolean isOrderedDateEmpty() {
        return orderedDate.isEmpty();
    }
}
