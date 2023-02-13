package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;

import java.util.List;

/**
 * 引当の一覧
 */
public class Allocations {
    List<Allocation> list;

    public Allocations(List<Allocation> list) {
        this.list = list;
    }

    public List<Allocation> list() {
        return list;
    }

    public Allocation allocationOf(SalesOrderItem salesOrderItem) {
        return list.stream()
                .filter(allocation -> allocation.isSame(salesOrderItem.salesOrderItemNumber()))
                .findFirst()
                .orElse(new Allocation());
    }
}
