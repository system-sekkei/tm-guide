package guide.tm.domain.model.shipping.content;

import guide.tm.domain.model.salesorder.order.SalesOrderId;

/**
 * 出荷
 */
public class ShippingInstructionContent {
    SalesOrderId salesOrderId;
    ShippingDate shippingDate;

    @Deprecated
    ShippingInstructionContent() {
        this(new SalesOrderId(), new ShippingDate());
    }

    public ShippingInstructionContent(SalesOrderId salesOrderId, ShippingDate shippingDate) {
        this.salesOrderId = salesOrderId;
        this.shippingDate = shippingDate;
    }

    public ShippingDate shippingDate() {
        return shippingDate;
    }
}
