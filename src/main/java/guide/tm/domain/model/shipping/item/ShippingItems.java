package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.allocation.status.ShippingStatus;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;

public class ShippingItems {
    SingleShippingItems singleShippingItems;
    BundleShippingItems bundleShippingItems;

    public ShippingItems(SingleShippingItems singleShippingItems, BundleShippingItems bundleShippingItems) {
        this.singleShippingItems = singleShippingItems;
        this.bundleShippingItems = bundleShippingItems;
    }


    public ShippingStatus statusOfSingleOrderItem(SingleOrderItem singleOrderItem) {
        return singleShippingItems.statusOf(singleOrderItem);
    }

    public ShippingStatus statusOfBundleOrderItem(BundleProductOrderItem bundleProductOrderItem) {
        return bundleShippingItems.statusOf(bundleProductOrderItem);
    }
}
