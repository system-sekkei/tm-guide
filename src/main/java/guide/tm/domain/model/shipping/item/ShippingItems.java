package guide.tm.domain.model.shipping.item;

import java.util.ArrayList;
import java.util.List;

/**
 * 出荷明細のリスト
 */
public class ShippingItems {

    List<ShippingItem> list;

    public ShippingItems() {
        this(new ArrayList<>());
    }

    public ShippingItems(List<ShippingItem> list) {
        this.list = list;
    }

    public List<ShippingItem> list() {
        return list;
    }
}
