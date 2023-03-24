package guide.tm.presentation.controller.allocation;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("allocate/sales-orders/{salesOrderId}")
class AllocateController {

    SalesOrderScenario salesOrderScenario;
    AllocationService allocationService;

    AllocateController(SalesOrderScenario salesOrderScenario, AllocationService allocationService) {
        this.salesOrderScenario = salesOrderScenario;
        this.allocationService = allocationService;
    }

    @PostMapping
    String allocateSalesOrder(@PathVariable("salesOrderId") SalesOrderId salesOrderId) {
        SalesOrderStatus salesOrderStatus = salesOrderScenario.status(salesOrderId);
        allocationService.allocateSalesOrder(salesOrderStatus, salesOrderId);
        return "redirect:/sales-orders/{salesOrderId}/allocations";
    }

}
