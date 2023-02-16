package guide.tm.application.scenario.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.application.service.shipping.ShippingService;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.allocation.status.SalesOrderStatus;
import guide.tm.domain.model.allocation.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.allocation.status.single.SingleOrderItemStatusList;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

        SingleOrderItemStatusList allocated = salesOrderStatus.singleOrderItemStatusList().allocated();
        SingleAllocations singleAllocationsToShip = allocated.notShippedItemAllocations();

        BundleOrderItemStatusList allocatedBundleOrderItem = salesOrderStatus.bundleOrderItemStatusList().allocated();
        BundleAllocations bundleAllocationsToShip = allocatedBundleOrderItem.notShippedItemAllocations();

        if (isAlreadyShipped(singleAllocationsToShip, bundleAllocationsToShip)) return;
        shippingService.register(new Shipping(salesOrderNumber, new ShippingDate(LocalDate.now())), singleAllocationsToShip, bundleAllocationsToShip);
    }

    private boolean isAlreadyShipped(SingleAllocations singleAllocationsToShip, BundleAllocations bundleAllocationsToShip) {
        return singleAllocationsToShip.isEmpty() && bundleAllocationsToShip.isEmpty();
    }

}
