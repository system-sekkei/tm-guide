package guide.tm.application.service.allocation;

import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.product.individual.SingleProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;

public interface AllocationRepository {
    /**
     * 個別商品の引当を登録する
     */
    void register(AllocatedLocations allocatedLocations, SalesOrderNumber salesOrderNumber, SingleOrderItem singleOrderItem);

    /**
     * セット商品の引当を登録する
     */
    BundleAllocationNumber registerBundleAllocation(
            SalesOrderNumber salesOrderNumber,
            BundleProductOrderItem bundleProductOrderItem);

    /**
     * セット商品の引当明細を登録する
     */
    void registerBundleAllocationItem(
            BundleAllocationNumber bundleAllocationNumber,
            AllocatedLocations allocatedLocations,
            SalesOrderNumber salesOrderNumber,
            SingleProduct singleProduct);

    /**
     * 個別商品の引当を取得する
     */
    SingleAllocations singleAllocationsOf(SalesOrderNumber salesOrderNumber);
//
//    Allocations allocationsOf(SalesOrderNumber salesOrderNumber);
//
//
//    BundleAllocations bundleAllocationsOf(SalesOrderNumber salesOrderNumber);
}
