package guide.tm.presentation.controller.shipping;

import guide.tm.application.scenario.shipping.ShippingInstructionScenario;
import guide.tm.application.service.shipping.ShippingInstructionService;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.summary.ShippingInstructionCriteria;
import guide.tm.domain.model.shipping.summary.ShippingInstructionStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("shipping/instructions")
class ShippingInstructionsController {

    ShippingInstructionService shippingInstructionService;
    ShippingInstructionScenario shippingInstructionScenario;

    ShippingInstructionsController(
            ShippingInstructionService shippingInstructionService, ShippingInstructionScenario shippingInstructionScenario) {
        this.shippingInstructionService = shippingInstructionService;
        this.shippingInstructionScenario = shippingInstructionScenario;
    }

    @ModelAttribute("shippingInstructionStatuses")
    ShippingInstructionStatus[] shippingInstructionStatuses() {
        return ShippingInstructionStatus.values();
    }


    @GetMapping
    String list(
            @ModelAttribute("shippingInstructionCriteria") ShippingInstructionCriteria shippingInstructionCriteria,
            Model model) {
        ShippingInstructionSummaries shippingInstructionSummaries = shippingInstructionService.shippingInstructionSummaries(shippingInstructionCriteria);
        model.addAttribute("shippingInstructionSummaries", shippingInstructionSummaries);
        return "shipping/shipping-instructions";
    }

    @PostMapping
    String markAsShipped(@ModelAttribute("shippingNumber") ShippingNumber shippingNumber) {
        shippingInstructionService.markAsShipped(shippingNumber);
        return "redirect:/shipping/instructions";
    }

    @PostMapping("sales-order/{salesOrderId}")
    String registerShippingInstruction(
            @PathVariable("salesOrderId") SalesOrderId salesOrderId,
            RedirectAttributes redirectAttributes) {
        shippingInstructionScenario.registerShippingOf(salesOrderId);
        redirectAttributes.addFlashAttribute("message", "出荷指示を登録しました");
        return "redirect:/allocations/sales-orders/{salesOrderId}";
    }

    @InitBinder({"shippingNumber"})
    void bindOrderItem(WebDataBinder binder) {
        binder.setAllowedFields(
                "value"
        );
    }

    @InitBinder("shippingInstructionCriteria")
    void bindSalesOrderContent(WebDataBinder binder) {
        binder.setAllowedFields(
                "shippingInstructionStatusList",
                "from.value",
                "to.value"
        );
    }
}
