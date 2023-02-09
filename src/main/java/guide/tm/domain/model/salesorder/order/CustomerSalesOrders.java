package guide.tm.domain.model.salesorder.order;

import java.util.List;

public class CustomerSalesOrders {
    List<CustomerSalesOrder> list;

    public CustomerSalesOrders(List<CustomerSalesOrder> list) {
        this.list = list;
    }

    public List<CustomerSalesOrder> list() {
        return list;
    }
}
