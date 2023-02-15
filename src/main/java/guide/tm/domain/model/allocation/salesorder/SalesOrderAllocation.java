package guide.tm.domain.model.allocation.salesorder;

import guide.tm.domain.model.allocation.bundle.BundleAllocation;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.salesorder.bundle.BundleOrderItemAllocation;
import guide.tm.domain.model.allocation.salesorder.bundle.BundleOrderItemAllocations;
import guide.tm.domain.model.allocation.salesorder.single.SingleOrderItemAllocation;
import guide.tm.domain.model.allocation.salesorder.single.SingleOrderItemAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

/**
 * 受注と引当
 */
public class SalesOrderAllocation {
    SalesOrderNumber salesOrderNumber;
    SalesOrder salesOrder;
    SingleAllocations singleAllocations;
    BundleAllocations bundleAllocations;

    public SalesOrderAllocation(SalesOrderNumber salesOrderNumber, SalesOrder salesOrder, SingleAllocations singleAllocations, BundleAllocations bundleAllocations) {
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrder = salesOrder;
        this.singleAllocations = singleAllocations;
        this.bundleAllocations = bundleAllocations;
    }

    public SingleOrderItemAllocations singleOrderItemAllocations() {
        return new SingleOrderItemAllocations(
                salesOrder.singleProductOrderItems().list().stream()
                        .map(salesOrderItem -> {
                            SingleAllocation allocation = singleAllocations.allocationOf(salesOrderItem);
                            return new SingleOrderItemAllocation(salesOrderItem, allocation);
                        }).toList());
    }

    /**
     * セット品の受注明細と引当のリストを返却する
     */
    public BundleOrderItemAllocations bundleOrderItemAllocations() {
        return new BundleOrderItemAllocations(
                salesOrder.bundleProductOrderItems().list().stream()
                        .map(salesOrderItem -> {
                            BundleAllocation allocation = bundleAllocations.allocationOf(salesOrderItem);
                            return new BundleOrderItemAllocation(salesOrderItem, allocation);
                        }).toList());
    }
}
