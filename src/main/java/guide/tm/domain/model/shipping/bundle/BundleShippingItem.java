package guide.tm.domain.model.shipping.bundle;

import guide.tm.domain.model.product.bundle.BundleProduct;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
import guide.tm.domain.primitive.Quantity;

/**
 * セット商品の出荷明細
 */
public class BundleShippingItem {
    SalesOrderItemNumber salesOrderItemNumber;
    BundleProduct bundleProduct;
    Quantity shippingQuantity;
}
