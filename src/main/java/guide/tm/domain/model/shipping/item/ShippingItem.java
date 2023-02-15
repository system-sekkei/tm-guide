package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.individual.SingleProduct;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;

/**
 * 出荷明細
 */
public class ShippingItem {

    SalesOrderItemNumber salesOrderItemNumber;
    SingleProduct singleProduct;
    Quantity shippingQuantity;

    @Deprecated ShippingItem() {
        this(new SalesOrderItemNumber(), new SingleProduct(), new Quantity());
    }

    public ShippingItem(SalesOrderItemNumber salesOrderItemNumber, SingleProduct singleProduct, Quantity shippingQuantity) {
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.singleProduct = singleProduct;
        this.shippingQuantity = shippingQuantity;
    }

    public static ShippingItem from(SingleOrderItem singleOrderItem) {
        return new ShippingItem(singleOrderItem.salesOrderItemNumber(), singleOrderItem.product(), singleOrderItem.quantity());
    }

    public SingleProduct individualProduct() {
        return singleProduct;
    }

    public Quantity shippingQuantity() {
        return shippingQuantity;
    }
}
