package guide.tm.domain.model.shipping.item;

import java.util.List;

/**
 * 出荷明細のリスト
 */
public class ShippingItems {

    List<ShippingItem> list;

    public ShippingItems(List<ShippingItem> list) {
        this.list = list;
    }
}
