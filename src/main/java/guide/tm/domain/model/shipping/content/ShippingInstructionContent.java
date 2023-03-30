package guide.tm.domain.model.shipping.content;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

/**
 * 出荷
 */
public class ShippingInstructionContent {
    SalesOrderId salesOrderId;
    SalesOrderNumber salesOrderNumber;
    ShippingDate shippingDate;

    @Deprecated
    ShippingInstructionContent() {
        this(new SalesOrderId(), new SalesOrderNumber(), new ShippingDate());
    }

    public ShippingInstructionContent(SalesOrderId salesOrderId, SalesOrderNumber salesOrderNumber, ShippingDate shippingDate) {
        this.salesOrderId = salesOrderId;
        this.salesOrderNumber = salesOrderNumber;
        this.shippingDate = shippingDate;
    }

    public SalesOrderNumber salesOrderNumber() {
        return salesOrderNumber;
    }

    public ShippingDate shippingDate() {
        return shippingDate;
    }
}
