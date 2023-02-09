package guide.tm.presentation.controller.allocation;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("allocate/sales-orders/{salesOrderNumber}")
class AllocateController {

    SalesOrderScenario salesOrderScenario;
    AllocationService allocationService;

    @PostMapping
    String allocateSalesOrder(@PathVariable SalesOrderNumber salesOrderNumber) {
        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
        allocationService.allocateSalesOrder(salesOrder, salesOrderNumber);
        return "TODO";
    }
}
