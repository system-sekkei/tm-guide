package guide.tm.presentation.controller.allocation;

import guide.tm.application.scenario.allocation.AllocationScenario;
import guide.tm.application.scenario.salesorder.SalesOrderScenario;
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
    AllocationScenario allocationScenario;

    AllocateController(SalesOrderScenario salesOrderScenario, AllocationScenario allocationScenario) {
        this.salesOrderScenario = salesOrderScenario;
        this.allocationScenario = allocationScenario;
    }

    @PostMapping
    String allocateSalesOrder(@PathVariable("salesOrderId") SalesOrderId salesOrderId) {
        SalesOrderStatus salesOrderStatus = salesOrderScenario.status(salesOrderId);
        allocationScenario.allocate(salesOrderStatus, salesOrderId);
        return "redirect:/sales-orders/{salesOrderId}/allocations";
    }

}
