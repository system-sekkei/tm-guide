package guide.tm.infrastructure.datasource.allocation;

import guide.tm.application.service.allocation.AllocationRepository;
import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
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
    public void register(AllocatedLocations allocatedLocations, SalesOrderNumber salesOrderNumber, SingleOrderItem singleOrderItem) {
        UUID allocationNumber = UUID.randomUUID();
        allocationMapper.registerSingleAllocation(allocationNumber, salesOrderNumber, singleOrderItem);
        allocatedLocations.list().forEach(allocatedLocation ->
            allocationMapper.registerSingleAllocationItem(allocationNumber, allocatedLocation)
        );
    }

    @Override
    public BundleAllocationNumber registerBundleAllocation(SalesOrderNumber salesOrderNumber, BundleProductOrderItem bundleProductOrderItem) {
        UUID allocationNumber = UUID.randomUUID();
        allocationMapper.registerBundleAllocation(allocationNumber, salesOrderNumber, bundleProductOrderItem);
        return new BundleAllocationNumber(allocationNumber.toString());
    }

    @Override
    public void registerBundleAllocationItem(
            BundleAllocationNumber bundleAllocationNumber,
            AllocatedLocations allocatedLocations,
            SalesOrderNumber salesOrderNumber,
            SingleProduct singleProduct) {
        allocatedLocations.list().forEach(allocatedLocation ->
            allocationMapper.registerBundleAllocationItem(bundleAllocationNumber, allocatedLocation, salesOrderNumber, singleProduct)
        );
    }

    @Override
    public SingleAllocations singleAllocationsOf(SalesOrderNumber salesOrderNumber) {
        return new SingleAllocations(allocationMapper.singleAllocationsOf(salesOrderNumber));
    }

    @Override
    public BundleAllocations bundleAllocations(SalesOrderNumber salesOrderNumber) {
        return new BundleAllocations(allocationMapper.bundleAllocationsOf(salesOrderNumber));
    }

}
