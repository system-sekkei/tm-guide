package guide.tm.application.scenario.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.application.service.shipping.ShippingService;
import org.springframework.stereotype.Service;

@Service
public class ShippingScenario {

    ShippingService shippingService;
    ShippingItemService shippingItemService;
    SalesOrderScenario salesOrderScenario;
    AllocationService allocationService;

    ShippingScenario(
            ShippingService shippingService,
            ShippingItemService shippingItemService,
            SalesOrderScenario salesOrderScenario,
            AllocationService allocationService) {
        this.shippingService = shippingService;
        this.shippingItemService = shippingItemService;
        this.salesOrderScenario = salesOrderScenario;
        this.allocationService = allocationService;
    }

    /**
     * 出荷を登録する
     */
//    public void registerShippingOf(SalesOrderNumber salesOrderNumber) {
//
//        SalesOrderAllocation salesOrderAllocation = salesOrderAllocation(salesOrderNumber);
//
//        SalesOrderItems shippedSalesOrderItems = new SalesOrderItems(List.of()); //TODO
//        SalesOrderItemAllocations allocated = salesOrderAllocation.salesOrderItemAllocations().allocated();
//        SalesOrderItemAllocations salesOrderItemsToShip = allocated.notShippedItemAllocations(shippedSalesOrderItems);
//
//
//        BundleProductOrderItems shippedBundleItems = new BundleProductOrderItems(List.of()); //TODO
//        BundleOrderItemAllocations allocatedBundleOrderItem = salesOrderAllocation.bundleProductOrderItemAllocations().allocated();
//        BundleOrderItemAllocations bundleItemsToShip = allocatedBundleOrderItem.notShippedItemAllocations(shippedBundleItems);
//
//        if (isAlreadyShipped(salesOrderItemsToShip, bundleItemsToShip)) return;
//        ShippingNumber shippingNumber =
//                shippingService.register(new Shipping(salesOrderNumber, new ShippingDate(LocalDate.now())), salesOrderItemsToShip, bundleItemsToShip);
//    }
//
//    private boolean isAlreadyShipped(SalesOrderItemAllocations salesOrderItemsToShip, BundleOrderItemAllocations bundleItemsToShip) {
//        return salesOrderItemsToShip.isEmpty() && bundleItemsToShip.isEmpty();
//    }
//
//    SalesOrderAllocation salesOrderAllocation(SalesOrderNumber salesOrderNumber) {
//        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
//        Allocations allocations = allocationService.allocationsOf(salesOrderNumber);
//        BundleAllocations bundleAllocations = allocationService.bundleAllocations(salesOrderNumber);
//        return new SalesOrderAllocation(salesOrderNumber, salesOrder, allocations, bundleAllocations);
//    }
}
