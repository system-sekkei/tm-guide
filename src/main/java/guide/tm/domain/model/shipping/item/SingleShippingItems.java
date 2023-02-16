package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.allocation.status.ShippingStatus;
import guide.tm.domain.model.product.individual.SingleProduct;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;

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

//    public SingleShippingItems toBeShipped(SingleShippingItems shippedItems) {
//        return new SingleShippingItems(
//                list.stream().filter(shippingItem -> {
//                    if (!shippedItems.contains(shippingItem.singleProduct)) return true;
//                    SingleShippingItem shippedItem = shippedItems.shippingItemOf(shippingItem.singleProduct);
//                    return !shippedItem.shippingQuantity.isEqual(shippedItem.shippingQuantity);
//                }).toList());
//    }

    private boolean contains(SingleProduct product) {
        return list.stream()
                .anyMatch(shippingItem -> shippingItem.singleProduct.code().isSame(product.code()));
    }

    private SingleShippingItem shippingItemOf(SingleProduct product) {
        return list.stream()
                .filter(shippingItem -> shippingItem.singleProduct.code().isSame(product.code()))
                .findFirst()
                .orElseThrow()
                ;
    }

    public ShippingStatus statusOf(SingleOrderItem singleOrderItem) {
        boolean isShipped = list.stream()
                .anyMatch(singleShippingItem -> singleShippingItem.salesOrderItemNumber.isSame(singleOrderItem.salesOrderItemNumber()));
        return isShipped ? ShippingStatus.出荷指示済 :ShippingStatus.出荷未指示;
    }
}
