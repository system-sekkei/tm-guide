package guide.tm.infrastructure.datasource.allocation;

import guide.tm.application.service.allocation.AllocationRepository;
import guide.tm.domain.model.allocation.allocation.AllocatedLocations;
import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.allocation.allocation.BundleAllocation;
import guide.tm.domain.model.allocation.allocation.BundleAllocations;
import guide.tm.domain.model.product.individual.IndividualProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AllocationDataSource implements AllocationRepository {

    AllocationMapper allocationMapper;

    AllocationDataSource(AllocationMapper allocationMapper) {
        this.allocationMapper = allocationMapper;
    }

    @Override
    public void register(
            AllocatedLocations allocatedLocations,
            SalesOrderNumber salesOrderNumber,
            SalesOrderItem salesOrderItem) {
        allocatedLocations.list().forEach(allocationContent -> {
            UUID allocationId = UUID.randomUUID();
            allocationMapper.register(allocationId, allocationContent, salesOrderNumber, salesOrderItem.salesOrderItemNumber(), salesOrderItem.product());
            allocationMapper.recordAllocatedStock(allocationId, allocationContent, salesOrderItem.product());
        });
    }

    @Override
    public Allocations allocationsOf(SalesOrderNumber salesOrderNumber) {
        return new Allocations(allocationMapper.allocationsOf(salesOrderNumber));
    }

    @Override
    public void register(
            AllocatedLocations allocatedLocations,
            SalesOrderNumber salesOrderNumber,
            SalesOrderItemNumber salesOrderItemNumber,
            IndividualProduct product) {
        allocatedLocations.list().forEach(allocationContent -> {
            UUID allocationId = UUID.randomUUID();
            allocationMapper.registerBundleProduct(allocationId, allocationContent, salesOrderNumber, salesOrderItemNumber, product);
            allocationMapper.recordAllocatedStock(allocationId, allocationContent, product);
        });
    }

    @Override
    public BundleAllocations bundleAllocationsOf(SalesOrderNumber salesOrderNumber) {
        List<BundleAllocation> bundleAllocations = allocationMapper.bundleAllocationsOf(salesOrderNumber);
        return new BundleAllocations(allocationMapper.bundleAllocationsOf(salesOrderNumber));
    }
}
