package guide.tm.presentation.controller.allocation;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.status.SalesOrderStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("allocate/sales-orders/{salesOrderNumber}")
class AllocateController {

    SalesOrderScenario salesOrderScenario;
    AllocationService allocationService;

    AllocateController(SalesOrderScenario salesOrderScenario, AllocationService allocationService) {
        this.salesOrderScenario = salesOrderScenario;
        this.allocationService = allocationService;
    }

    @PostMapping
    String allocateSalesOrder(@PathVariable SalesOrderNumber salesOrderNumber) {
        SalesOrderStatus salesOrderStatus = salesOrderScenario.status(salesOrderNumber);
        allocationService.allocateSalesOrder(salesOrderStatus, salesOrderNumber);
        return "redirect:/sales-orders/{salesOrderNumber}/allocations";
    }

}
