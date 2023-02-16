package guide.tm.application.scenario.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.application.service.shipping.ShippingService;
import guide.tm.domain.model.allocation.status.SalesOrderStatus;
import guide.tm.domain.model.allocation.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.allocation.status.single.SingleOrderItemStatusList;
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

        SalesOrderStatus salesOrderStatus = salesOrderScenario.status(salesOrderNumber);

        SingleOrderItemStatusList shippedSingleOrderItems = new SingleOrderItemStatusList(); //TODO
        SingleOrderItemStatusList allocated = salesOrderStatus.singleOrderItemStatusList().allocated();
        SingleOrderItemStatusList singleOrderItemsToShip = allocated.notShippedItemAllocations(shippedSingleOrderItems);


        BundleOrderItemStatusList shippedBundleItems = new BundleOrderItemStatusList(List.of()); //TODO
        BundleOrderItemStatusList allocatedBundleOrderItem = salesOrderStatus.bundleOrderItemStatusList().allocated();
        BundleOrderItemStatusList bundleItemsToShip = allocatedBundleOrderItem.notShippedItemAllocations(shippedBundleItems);

        if (isAlreadyShipped(singleOrderItemsToShip, bundleItemsToShip)) return;
        shippingService.register(new Shipping(salesOrderNumber, new ShippingDate(LocalDate.now())), singleOrderItemsToShip, bundleItemsToShip);
    }

    private boolean isAlreadyShipped(SingleOrderItemStatusList singleOrderItemsToShip, BundleOrderItemStatusList bundleItemsToShip) {
        return singleOrderItemsToShip.isEmpty() && bundleItemsToShip.isEmpty();
    }

}
