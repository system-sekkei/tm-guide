package guide.tm.application.service.allocation;

import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.allocation.summary.AllocationSummaries;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;

public interface AllocationRepository {
    /**
     * 個別商品の引当を登録する
     */
    void register(AllocatedLocations allocatedLocations, SalesOrderId salesOrderId, SingleOrderItem singleOrderItem);

    /**
     * セット商品の引当を登録する
     */
    BundleAllocationNumber registerBundleAllocation(
            SalesOrderId salesOrderId,
            BundleProductOrderItem bundleProductOrderItem);

    /**
     * セット商品の引当明細を登録する
     */
    void registerBundleAllocationItem(
            BundleAllocationNumber bundleAllocationNumber,
            AllocatedLocations allocatedLocations,
            SalesOrderId salesOrderId,
            SingleProduct singleProduct);

    /**
     * 個別商品の引当を取得する
     */
    SingleAllocations singleAllocationsOf(SalesOrderId salesOrderId);

    /**
     * セット商品の引当を取得する
     */
    BundleAllocations bundleAllocations(SalesOrderId salesOrderId);

    void markAsCompleted(SalesOrderId salesOrderId);

    AllocationSummaries search();
}
