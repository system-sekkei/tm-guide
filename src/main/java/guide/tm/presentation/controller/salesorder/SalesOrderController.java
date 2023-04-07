package guide.tm.presentation.controller.salesorder;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderSearchCriteria;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sales-orders")
class SalesOrderController {

    SalesOrderScenario salesOrderScenario;
    SalesOrderService salesOrderService;

    SalesOrderController(
            SalesOrderScenario salesOrderScenario,
            SalesOrderService salesOrderService
            ) {
        this.salesOrderScenario = salesOrderScenario;
        this.salesOrderService = salesOrderService;
    }

    @GetMapping
    String salesOrderList(
            @ModelAttribute("salesOrderSearchCriteria") SalesOrderSearchCriteria salesOrderSearchCriteria,
            Model model) {
        SalesOrderSummaries salesOrderSummaries = salesOrderService.salesOrderSummaries(salesOrderSearchCriteria);
        model.addAttribute("salesOrderSummaries", salesOrderSummaries);
        return "sales-order/sales-order-list";
    }

    @GetMapping("{salesOrderId}")
    String salesOrder(@PathVariable("salesOrderId") SalesOrderId salesOrderId,
                      Model model) {
        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderId);
        model.addAttribute("salesOrder", salesOrder);
        model.addAttribute("salesOrderItemRequest", new SalesOrderItemRequest());
        return "sales-order/sales-order";
    }

    @PostMapping("{salesOrderId}")
    String complete(@PathVariable("salesOrderId") SalesOrderId salesOrderId) {
        salesOrderService.markAsOrdered(salesOrderId);
        return "redirect:/sales-orders";
    }

    @InitBinder("salesOrderSearchCriteria")
    void bindSalesOrderContent(WebDataBinder binder) {
        binder.setAllowedFields(
                "from.value",
                "to.value",
                "customerName"
        );
    }
}
