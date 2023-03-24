package guide.tm.infrastructure.datasource.allocation;

import guide.tm.application.service.allocation.AllocationRepository;
import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AllocationDataSource implements AllocationRepository {

    AllocationMapper allocationMapper;

    AllocationDataSource(AllocationMapper allocationMapper) {
        this.allocationMapper = allocationMapper;
    }

    @Override
    public void register(AllocatedLocations allocatedLocations, SalesOrderId salesOrderId, SingleOrderItem singleOrderItem) {
        UUID allocationNumber = UUID.randomUUID();
        allocationMapper.registerSingleAllocation(allocationNumber, salesOrderId, singleOrderItem);
        allocatedLocations.list().forEach(allocatedLocation ->
            allocationMapper.registerSingleAllocationItem(allocationNumber, allocatedLocation)
        );
    }

    @Override
    public BundleAllocationNumber registerBundleAllocation(SalesOrderId salesOrderId, BundleProductOrderItem bundleProductOrderItem) {
        UUID allocationNumber = UUID.randomUUID();
        allocationMapper.registerBundleAllocation(allocationNumber, salesOrderId, bundleProductOrderItem);
        return new BundleAllocationNumber(allocationNumber.toString());
    }

    @Override
    public void registerBundleAllocationItem(
            BundleAllocationNumber bundleAllocationNumber,
            AllocatedLocations allocatedLocations,
            SalesOrderId salesOrderId,
            SingleProduct singleProduct) {
        allocatedLocations.list().forEach(allocatedLocation ->
            allocationMapper.registerBundleAllocationItem(bundleAllocationNumber, allocatedLocation, salesOrderId, singleProduct)
        );
    }

    @Override
    public SingleAllocations singleAllocationsOf(SalesOrderId salesOrderId) {
        return new SingleAllocations(allocationMapper.singleAllocationsOf(salesOrderId));
    }

    @Override
    public BundleAllocations bundleAllocations(SalesOrderId salesOrderId) {
        return new BundleAllocations(allocationMapper.bundleAllocationsOf(salesOrderId));
    }

}
