package guide.tm.domain.model.shipping.single;

import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import guide.tm.domain.model.shipping.status.ShippingStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * 出荷明細のリスト
 */
public class SingleShippingItems {

    List<SingleShippingItem> list;

    @Deprecated
    SingleShippingItems() {
        this(new ArrayList<>());
    }

    public SingleShippingItems(List<SingleShippingItem> list) {
        this.list = list;
    }

    public List<SingleShippingItem> list() {
        return list;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public ShippingStatus statusOf(SingleOrderItem singleOrderItem) {
        boolean isShipped = list.stream()
                .anyMatch(singleShippingItem -> singleShippingItem.salesOrderItemNumber.isSame(singleOrderItem.salesOrderItemNumber()));
        return isShipped ? ShippingStatus.出荷指示済 :ShippingStatus.出荷未指示;
    }
}
