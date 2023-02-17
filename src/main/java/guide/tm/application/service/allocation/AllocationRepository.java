package guide.tm.application.service.allocation;

import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;

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

    /**
     * セット商品の引当を取得する
     */
    BundleAllocations bundleAllocations(SalesOrderNumber salesOrderNumber);
}
