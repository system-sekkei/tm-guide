package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.primitive.Amount;

import java.util.List;

/**
 * 受注一覧
 */
public class SalesOrders {
    List<SalesOrder> list;

    public SalesOrders(List<SalesOrder> list) {
        this.list = list;
    }

    public List<SalesOrder> list() {
        return list;
    }

    public Amount totalAmount() {
        return list.stream().map(SalesOrder::totalAmount).reduce(Amount::add).orElse(new Amount());
    }
    public Amount totalTax() {
        return list.stream().map(SalesOrder::tax).reduce(Amount::add).orElse(new Amount());
    }
}
