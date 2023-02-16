package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.product.bundle.BundleProduct;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import guide.tm.domain.primitive.Quantity;

public class BundleShippingItem {
    SalesOrderItemNumber salesOrderItemNumber;
    BundleProduct bundleProduct;
    Quantity shippingQuantity;
}
