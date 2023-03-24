package guide.tm.application.scenario.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.application.service.shipping.ShippingService;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.content.ShippingInstruction;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import org.springframework.stereotype.Service;

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
    public void registerShippingOf(SalesOrderId salesOrderId) {

        SalesOrderStatus salesOrderStatus = salesOrderScenario.status(salesOrderId);

        ShippingInstruction shippingInstruction = salesOrderStatus.create();

        if (shippingInstruction.isAllShipped()) return;
        shippingService.register(shippingInstruction);

    }

}
