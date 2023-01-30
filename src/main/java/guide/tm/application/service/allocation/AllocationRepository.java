package guide.tm.application.service.allocation;

import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.salesorder.SalesOrderItem;
import guide.tm.domain.model.salesorder.SalesOrderNumber;

public interface AllocationRepository {
    void register(Allocations allocations, SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem);
}
