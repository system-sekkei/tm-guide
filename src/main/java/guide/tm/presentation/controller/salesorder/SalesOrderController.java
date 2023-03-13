package guide.tm.presentation.controller.salesorder;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSearchCriteria;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
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

    @GetMapping("{salesOrderNumber}")
    String salesOrder(@PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
                      Model model) {
        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
        model.addAttribute("salesOrder", salesOrder);
        model.addAttribute("salesOrderItemRequest", new SalesOrderItemRequest());
        return "sales-order/sales-order";
    }

    @GetMapping("{salesOrderNumber}/allocations")
    String allocations(@PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
                       Model model) {
        SalesOrderStatus status = salesOrderScenario.status(salesOrderNumber);
        model.addAttribute("salesOrderStatus", status);
        return "sales-order/allocations";
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
