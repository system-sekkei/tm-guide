package guide.tm.domain.model.status.orderstatus;

import guide.tm.domain.model.allocation.bundle.BundleAllocation;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.content.Allocations;
import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.content.ShippingDate;
import guide.tm.domain.model.shipping.content.ShippingInstruction;
import guide.tm.domain.model.shipping.content.ShippingInstructionContent;
import guide.tm.domain.model.shipping.item.ShippingItems;
import guide.tm.domain.model.shipping.status.ShippingStatus;
import guide.tm.domain.model.status.bundle.BundleOrderItemStatus;
import guide.tm.domain.model.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.status.single.SingleOrderItemStatus;
import guide.tm.domain.model.status.single.SingleOrderItemStatusList;

import java.time.LocalDate;

/**
 * 受注状況
 */
public class SalesOrderStatus {
    SalesOrderId salesOrderId;
    SalesOrder salesOrder;
    Allocations allocations;
    ShippingItems shippingItems;

    public SalesOrderStatus(
            SalesOrderId salesOrderId, SalesOrder salesOrder, Allocations allocations, ShippingItems shippingItems) {
        this.salesOrderId = salesOrderId;
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

    /**
     * 出荷指示を作成する
     *
     * - 引当済
     * - 未出荷
     * の引当を対象として、出荷指示を作成する
     */
    public ShippingInstruction create() {
        SingleOrderItemStatusList allocated = singleOrderItemStatusList().allocated();
        SingleAllocations singleAllocationsToShip = allocated.notShippedItemAllocations();

        BundleOrderItemStatusList allocatedBundleOrderItem = bundleOrderItemStatusList().allocated();
        BundleAllocations bundleAllocationsToShip = allocatedBundleOrderItem.notShippedItemAllocations();

        return new ShippingInstruction(
                new ShippingInstructionContent(salesOrderId(), new ShippingDate(LocalDate.now())),
                singleAllocationsToShip,
                bundleAllocationsToShip);
    }

    public SalesOrderId salesOrderId() {
        return salesOrderId;
    }

    public SalesOrder salesOrder() {
        return salesOrder;
    }

}
