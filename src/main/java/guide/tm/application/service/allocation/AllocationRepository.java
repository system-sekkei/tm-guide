package guide.tm.application.service.allocation;

import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

public interface AllocationRepository {
    void register(Allocations allocations, SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem);
}
