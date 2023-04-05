package guide.tm.domain.model.invoice;

import java.util.List;

public class InvoicedSalesOrders {
    List<InvoicedSalesOrder> list;

    public InvoicedSalesOrders(List<InvoicedSalesOrder> list) {
        this.list = list;
    }

    public List<InvoicedSalesOrder> list() {
        return list;
    }
}
