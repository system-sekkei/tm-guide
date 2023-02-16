package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.allocation.status.ShippingStatus;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;

import java.util.List;

public class BundleShippingItems {
    List<BundleShippingItem> list;

    public BundleShippingItems(List<BundleShippingItem> list) {
        this.list = list;
    }

    public List<BundleShippingItem> list() {
        return list;
    }

    public ShippingStatus statusOf(BundleProductOrderItem bundleProductOrderItem) {
        boolean isShipped = list.stream()
                .anyMatch(bundleShippingItem -> bundleShippingItem.salesOrderItemNumber.isSame(bundleProductOrderItem.salesOrderItemNumber()));
        return isShipped ? ShippingStatus.出荷指示済 :ShippingStatus.出荷未指示;
    }
}
