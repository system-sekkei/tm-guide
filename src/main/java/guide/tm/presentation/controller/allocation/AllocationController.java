package guide.tm.presentation.controller.allocation;

import guide.tm.application.scenario.allocation.AllocationScenario;
import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.domain.model.allocation.summary.AllocatedStatus;
import guide.tm.domain.model.allocation.summary.AllocationCriteria;
import guide.tm.domain.model.allocation.summary.AllocationSummaries;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("allocations")
class AllocationController {

    SalesOrderScenario salesOrderScenario;
    AllocationService allocationService;
    AllocationScenario allocationScenario;

    AllocationController(
            SalesOrderScenario salesOrderScenario,
            AllocationService allocationService,
            AllocationScenario allocationScenario) {
        this.salesOrderScenario = salesOrderScenario;
        this.allocationService = allocationService;
        this.allocationScenario = allocationScenario;
    }

    @ModelAttribute("allocatedStatuses")
    AllocatedStatus[] allocatedStatuses() {
        return AllocatedStatus.values();
    }

    @GetMapping
    String list(
            @ModelAttribute("allocationCriteria") AllocationCriteria allocationCriteria,
            Model model) {

        AllocationSummaries allocationSummaries = allocationService.search(allocationCriteria);
        model.addAttribute("allocationSummaries", allocationSummaries);

        return "allocation/allocations";
    }

    @PostMapping("sales-orders/{salesOrderId}")
    String allocate(@PathVariable SalesOrderId salesOrderId) {
        SalesOrderStatus salesOrderStatus = salesOrderScenario.status(salesOrderId);
        allocationScenario.allocate(salesOrderStatus, salesOrderId);
        return "redirect:/allocations/sales-orders/{salesOrderId}";
    }


    @GetMapping("sales-orders/{salesOrderId}")
    String allocations(@PathVariable("salesOrderId") SalesOrderId salesOrderId,
                       Model model) {
        SalesOrderStatus status = salesOrderScenario.status(salesOrderId);
        model.addAttribute("salesOrderStatus", status);
        return "sales-order/allocations";
    }


    @InitBinder("allocationCriteria")
    void bindSalesOrderContent(WebDataBinder binder) {
        binder.setAllowedFields(
                "allocationStatusList",
                "from.value",
                "to.value"
        );
    }

}
