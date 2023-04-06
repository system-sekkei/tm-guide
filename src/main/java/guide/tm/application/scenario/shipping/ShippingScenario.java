package guide.tm.application.scenario.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.invoice.InvoiceService;
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
    InvoiceService invoiceService;

    ShippingScenario(
            ShippingService shippingService,
            ShippingItemService shippingItemService,
            SalesOrderScenario salesOrderScenario,
            AllocationService allocationService,
            InvoiceService invoiceService) {
        this.shippingService = shippingService;
        this.shippingItemService = shippingItemService;
        this.salesOrderScenario = salesOrderScenario;
        this.allocationService = allocationService;
        this.invoiceService = invoiceService;
    }

    /**
     * 出荷指示を登録する
     *
     * - 全ての引当が出荷指示済の場合、何もしない
     * - 出荷指示のない引当に対して、出荷指示を行う
     * - 全受注明細が指示済の場合、指示済を記録する
     */
    public void registerShippingOf(SalesOrderId salesOrderId) {

        SalesOrderStatus salesOrderStatus = salesOrderScenario.status(salesOrderId);
        ShippingInstruction shippingInstruction = salesOrderStatus.create();;

        // 出荷指示する引当がない
        if (shippingInstruction.isAllInstructed()) return;

        shippingService.register(shippingInstruction);

        // 全受注明細が出荷指示済
        SalesOrderStatus afterInstructedSalesOrderStatus = salesOrderScenario.status(salesOrderId);
        ShippingInstruction afterInstructed = afterInstructedSalesOrderStatus.create();;
        if (afterInstructedSalesOrderStatus.isAllAllocated() && afterInstructed.isAllInstructed()) {
            shippingService.markAsInstructed(salesOrderId);
            invoiceService.recordUnInvoiced(salesOrderId);
        }

    }

}
