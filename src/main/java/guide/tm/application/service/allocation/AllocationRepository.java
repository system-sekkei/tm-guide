package guide.tm.application.service.allocation;

import guide.tm.domain.model.allocation.allocation.AllocationContents;
import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;

public interface AllocationRepository {
    void register(AllocationContents allocationContents, SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem);

    Allocations allocationsOf(SalesOrderNumber salesOrderNumber);
}
