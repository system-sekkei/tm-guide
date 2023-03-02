package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import guide.tm.domain.model.shipping.bundle.BundleShippingItems;
import guide.tm.domain.model.shipping.single.SingleShippingItems;
import guide.tm.domain.model.shipping.status.ShippingStatus;

/**
 * 出荷指示明細
 */
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

    public SingleShippingItems singleShippingItems() {
        return singleShippingItems;
    }

    public BundleShippingItems bundleShippingItems() {
        return bundleShippingItems;
    }
}
