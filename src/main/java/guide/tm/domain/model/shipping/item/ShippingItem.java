package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.individual.IndividualProduct;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;

/**
 * 出荷明細
 */
public class ShippingItem {

    SalesOrderItemNumber salesOrderItemNumber;
    IndividualProduct individualProduct;
    Quantity shippingQuantity;

    @Deprecated ShippingItem() {
        this(new SalesOrderItemNumber(), new IndividualProduct(), new Quantity());
    }

    public ShippingItem(SalesOrderItemNumber salesOrderItemNumber, IndividualProduct individualProduct, Quantity shippingQuantity) {
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.individualProduct = individualProduct;
        this.shippingQuantity = shippingQuantity;
    }

    public static ShippingItem from(SalesOrderItem salesOrderItem) {
        return new ShippingItem(salesOrderItem.salesOrderItemNumber(), salesOrderItem.product(), salesOrderItem.quantity());
    }

    public IndividualProduct individualProduct() {
        return individualProduct;
    }

    public Quantity shippingQuantity() {
        return shippingQuantity;
    }
}
