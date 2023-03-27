package guide.tm.presentation.controller.allocation;

import guide.tm.application.service.allocation.AllocationService;
import guide.tm.domain.model.allocation.summary.AllocationSummaries;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("allocations")
class AllocationController {

    AllocationService allocationService;

    AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @GetMapping
    String list(Model model) {

        AllocationSummaries allocationSummaries = allocationService.search();
        model.addAttribute("allocationSummaries", allocationSummaries);

        return "allocation/allocations";
    }

}
