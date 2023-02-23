package guide.tm.domain.model.shipping.content;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

/**
 * 出荷
 */
public class ShippingInstructionContent {
    SalesOrderNumber salesOrderNumber;
    ShippingDate shippingDate;

    @Deprecated
    ShippingInstructionContent() {
        this(new SalesOrderNumber(), new ShippingDate());
    }

    public ShippingInstructionContent(SalesOrderNumber salesOrderNumber, ShippingDate shippingDate) {
        this.salesOrderNumber = salesOrderNumber;
        this.shippingDate = shippingDate;
    }

    public ShippingDate shippingDate() {
        return shippingDate;
    }
}
