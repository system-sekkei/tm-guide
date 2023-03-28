package guide.tm.presentation.controller.allocation;

import guide.tm.application.service.allocation.AllocationService;
import guide.tm.domain.model.allocation.summary.AllocatedStatus;
import guide.tm.domain.model.allocation.summary.AllocationCriteria;
import guide.tm.domain.model.allocation.summary.AllocationSummaries;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("allocations")
class AllocationController {

    AllocationService allocationService;

    AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @ModelAttribute("allocationCriteria")
    AllocationCriteria allocationCriteria() {
        return new AllocationCriteria();
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


    @InitBinder("allocationCriteria")
    void bindSalesOrderContent(WebDataBinder binder) {
        binder.setAllowedFields(
                "allocationStatusList",
                "from.value",
                "to.value"
        );
    }

}
