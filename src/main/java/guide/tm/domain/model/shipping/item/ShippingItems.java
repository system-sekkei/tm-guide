package guide.tm.domain.model.shipping.item;

import guide.tm.domain.model.product.individual.SingleProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * 出荷明細のリスト
 */
public class ShippingItems {

    List<ShippingItem> list;

    @Deprecated ShippingItems() {
        this(new ArrayList<>());
    }

    public ShippingItems(List<ShippingItem> list) {
        this.list = list;
    }

    public List<ShippingItem> list() {
        return list;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public ShippingItems toBeShipped(ShippingItems shippedItems) {
        return new ShippingItems(
                list.stream().filter(shippingItem -> {
                    if (!shippedItems.contains(shippingItem.singleProduct)) return true;
                    ShippingItem shippedItem = shippedItems.shippingItemOf(shippingItem.singleProduct);
                    return !shippedItem.shippingQuantity.isEqual(shippedItem.shippingQuantity);
                }).toList());
    }

    private boolean contains(SingleProduct product) {
        return list.stream()
                .anyMatch(shippingItem -> shippingItem.singleProduct.code().isSame(product.code()));
    }

    private ShippingItem shippingItemOf(SingleProduct product) {
        return list.stream()
                .filter(shippingItem -> shippingItem.singleProduct.code().isSame(product.code()))
                .findFirst()
                .orElseThrow()
                ;
    }
}
