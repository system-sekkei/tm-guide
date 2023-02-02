package guide.tm.domain.model.salesorder.order;

import java.util.List;

/**
 * 受注のリスト
 */
public class SalesOrders {
    List<SalesOrder> list;

    public SalesOrders(List<SalesOrder> list) {
        this.list = list;
    }

    public List<SalesOrder> list() {
        return list;
    }
}
