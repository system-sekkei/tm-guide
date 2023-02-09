package guide.tm.domain.model.salesorder.order;

import java.util.List;

public class SalesOrders {
    List<SalesOrder> list;

    public SalesOrders(List<SalesOrder> list) {
        this.list = list;
    }

    public List<SalesOrder> list() {
        return list;
    }
}
