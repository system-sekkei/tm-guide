package guide.tm.application.scenario.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.application.service.shipping.ShippingService;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.salesorder.SalesOrderAllocation;
import guide.tm.domain.model.allocation.salesorder.bundle.BundleOrderItemAllocations;
import guide.tm.domain.model.allocation.salesorder.single.SingleOrderItemAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    public void registerShippingOf(SalesOrderNumber salesOrderNumber) {

        SalesOrderAllocation salesOrderAllocation = salesOrderAllocation(salesOrderNumber);

        SingleOrderItemAllocations shippedSingleOrderItems = new SingleOrderItemAllocations(); //TODO
        SingleOrderItemAllocations allocated = salesOrderAllocation.singleOrderItemAllocations().allocated();
        SingleOrderItemAllocations singleOrderItemsToShip = allocated.notShippedItemAllocations(shippedSingleOrderItems);


        BundleOrderItemAllocations shippedBundleItems = new BundleOrderItemAllocations(List.of()); //TODO
        BundleOrderItemAllocations allocatedBundleOrderItem = salesOrderAllocation.bundleOrderItemAllocations().allocated();
        BundleOrderItemAllocations bundleItemsToShip = allocatedBundleOrderItem.notShippedItemAllocations(shippedBundleItems);

        if (isAlreadyShipped(singleOrderItemsToShip, bundleItemsToShip)) return;
        shippingService.register(new Shipping(salesOrderNumber, new ShippingDate(LocalDate.now())), singleOrderItemsToShip, bundleItemsToShip);
    }

    private boolean isAlreadyShipped(SingleOrderItemAllocations singleOrderItemsToShip, BundleOrderItemAllocations bundleItemsToShip) {
        return singleOrderItemsToShip.isEmpty() && bundleItemsToShip.isEmpty();
    }

    SalesOrderAllocation salesOrderAllocation(SalesOrderNumber salesOrderNumber) {
        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
        SingleAllocations singleAllocations = allocationService.singleAllocationsOf(salesOrderNumber);
        BundleAllocations bundleAllocations = allocationService.bundleAllocations(salesOrderNumber);
        return new SalesOrderAllocation(salesOrderNumber, salesOrder, singleAllocations, bundleAllocations);
    }
}
