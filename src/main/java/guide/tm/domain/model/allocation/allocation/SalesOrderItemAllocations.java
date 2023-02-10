package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;

import java.util.List;

public class SalesOrderItemAllocations {
    List<SalesOrderItemAllocation> list;

    public SalesOrderItemAllocations(List<SalesOrderItemAllocation> list) {
        this.list = list;
    }

    public SalesOrderItems allocatedSaleOrderItems() {
        return new SalesOrderItems(
                list.stream()
                        .filter(SalesOrderItemAllocation::isAllAllocated)
                        .map(SalesOrderItemAllocation::salesOrderItem)
                        .toList());
    }

    public List<SalesOrderItemAllocation> list() {
        return list;
    }
}
