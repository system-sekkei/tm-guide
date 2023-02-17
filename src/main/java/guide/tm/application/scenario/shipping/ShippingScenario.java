package guide.tm.application.scenario.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.application.service.shipping.ShippingService;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingDate;
import guide.tm.domain.model.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import guide.tm.domain.model.status.single.SingleOrderItemStatusList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * 出荷指示シナリオ
 */
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
     *
     * - 全ての引当が出荷済の場合、何もしない
     * - 出荷指示のない引当に対して、出荷指示を行う
     */
    public void registerShippingOf(SalesOrderNumber salesOrderNumber) {

        SalesOrderStatus salesOrderStatus = salesOrderScenario.status(salesOrderNumber);

        SingleOrderItemStatusList allocated = salesOrderStatus.singleOrderItemStatusList().allocated();
        SingleAllocations singleAllocationsToShip = allocated.notShippedItemAllocations();

        BundleOrderItemStatusList allocatedBundleOrderItem = salesOrderStatus.bundleOrderItemStatusList().allocated();
        BundleAllocations bundleAllocationsToShip = allocatedBundleOrderItem.notShippedItemAllocations();

        if (isAllShipped(singleAllocationsToShip, bundleAllocationsToShip)) return;
        shippingService.register(new Shipping(salesOrderNumber, new ShippingDate(LocalDate.now())), singleAllocationsToShip, bundleAllocationsToShip);
    }

    private boolean isAllShipped(SingleAllocations singleAllocationsToShip, BundleAllocations bundleAllocationsToShip) {
        return singleAllocationsToShip.isEmpty() && bundleAllocationsToShip.isEmpty();
    }

}
