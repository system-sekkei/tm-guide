package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.Product;
import guide.tm.domain.model.salesorder.SalesOrderItem;

/**
 * 出荷明細
 */
public class ShippingItem {
    Product product;
    Quantity shippingQuantity;

    @Deprecated ShippingItem() {
        this(new Product(), new Quantity());
    }

    public ShippingItem(Product product, Quantity shippingQuantity) {
        this.product = product;
        this.shippingQuantity = shippingQuantity;
    }

    public static ShippingItem from(SalesOrderItem salesOrderItem) {
        return new ShippingItem(salesOrderItem.product(), salesOrderItem.quantity());
    }
}
