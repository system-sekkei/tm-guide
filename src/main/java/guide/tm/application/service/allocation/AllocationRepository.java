package guide.tm.application.service.allocation;

import guide.tm.domain.model.allocation.allocation.AllocatedLocations;
import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.allocation.allocation.BundleAllocations;
import guide.tm.domain.model.product.individual.IndividualProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;

public interface AllocationRepository {
    void register(
            AllocatedLocations allocatedLocations,
            SalesOrderNumber salesOrderNumber,
            SalesOrderItem salesOrderItem);

    Allocations allocationsOf(SalesOrderNumber salesOrderNumber);

    void register(
            AllocatedLocations allocatedLocations,
            SalesOrderNumber salesOrderNumber,
            SalesOrderItemNumber salesOrderItemNumber,
            IndividualProduct product);

    BundleAllocations bundleAllocationsOf(SalesOrderNumber salesOrderNumber);
}
