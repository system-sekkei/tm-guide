package guide.tm.domain.model.status;

import guide.tm.domain.model.allocation.Allocations;
import guide.tm.domain.model.allocation.bundle.BundleAllocation;
import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.item.ShippingItems;
import guide.tm.domain.model.shipping.item.ShippingStatus;
import guide.tm.domain.model.status.bundle.BundleOrderItemStatus;
import guide.tm.domain.model.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.status.single.SingleOrderItemStatus;
import guide.tm.domain.model.status.single.SingleOrderItemStatusList;

/**
 * 受注状況
 */
public class SalesOrderStatus {
    SalesOrderNumber salesOrderNumber;
    SalesOrder salesOrder;
    Allocations allocations;
    ShippingItems shippingItems;

    public SalesOrderStatus(
            SalesOrderNumber salesOrderNumber, SalesOrder salesOrder, Allocations allocations, ShippingItems shippingItems) {
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrder = salesOrder;
        this.allocations = allocations;
        this.shippingItems = shippingItems;
    }

    public SingleOrderItemStatusList singleOrderItemStatusList() {
        return new SingleOrderItemStatusList(
                salesOrder.singleProductOrderItems().list().stream()
                        .map(singleOrderItem -> {
                            SingleAllocation allocation = allocations.singleAllocations().allocationOf(singleOrderItem);
                            ShippingStatus shippingStatus = shippingItems.statusOfSingleOrderItem(singleOrderItem);
                            return new SingleOrderItemStatus(singleOrderItem, allocation, shippingStatus);
                        }).toList());
    }

    /**
     * セット品の受注明細と引当のリストを返却する
     */
    public BundleOrderItemStatusList bundleOrderItemStatusList() {
        return new BundleOrderItemStatusList(
                salesOrder.bundleProductOrderItems().list().stream()
                        .map(bundleProductOrderItem -> {
                            BundleAllocation allocation = allocations.bundleAllocations().allocationOf(bundleProductOrderItem);
                            ShippingStatus shippingStatus = shippingItems.statusOfBundleOrderItem(bundleProductOrderItem);
                            return new BundleOrderItemStatus(bundleProductOrderItem, allocation, shippingStatus);
                        }).toList());
    }

    public SalesOrder salesOrder() {
        return salesOrder;
    }

}
