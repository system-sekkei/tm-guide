package guide.tm.domain.model.shipping.content;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

/**
 * 出荷
 */
public class Shipping {
    SalesOrderNumber salesOrderNumber;
    ShippingDate shippingDate;

    @Deprecated Shipping() {
        this(new SalesOrderNumber(), new ShippingDate());
    }

    public Shipping(SalesOrderNumber salesOrderNumber, ShippingDate shippingDate) {
        this.salesOrderNumber = salesOrderNumber;
        this.shippingDate = shippingDate;
    }

}
