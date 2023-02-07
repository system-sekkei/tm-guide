package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.individual.IndividualProduct;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;

/**
 * 出荷明細
 */
public class ShippingItem {
    IndividualProduct individualProduct;
    Quantity shippingQuantity;

    @Deprecated ShippingItem() {
        this(new IndividualProduct(), new Quantity());
    }

    public ShippingItem(IndividualProduct individualProduct, Quantity shippingQuantity) {
        this.individualProduct = individualProduct;
        this.shippingQuantity = shippingQuantity;
    }

    public static ShippingItem from(SalesOrderItem salesOrderItem) {
        return new ShippingItem(salesOrderItem.product(), salesOrderItem.quantity());
    }
}
