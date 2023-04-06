package guide.tm.domain.model.salesorder.order;

import java.util.List;

public class SalesOrderIdList {

    List<SalesOrderId> list;

    public SalesOrderIdList(List<SalesOrderId> list) {
        this.list = list;
    }

    public List<SalesOrderId> list() {
        return list;
    }
}
