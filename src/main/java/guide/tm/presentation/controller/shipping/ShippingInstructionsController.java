package guide.tm.presentation.controller.shipping;

import guide.tm.application.service.shipping.ShippingService;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("shipping/instructions")
class ShippingInstructionsController {

    ShippingService shippingService;

    ShippingInstructionsController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping
    String list(Model model) {
        ShippingInstructionSummaries shippingInstructionSummaries = shippingService.shippingInstructionSummaries();
        model.addAttribute("shippingInstructionSummaries", shippingInstructionSummaries);
        return "shipping/shipping-instructions";
    }

    @PostMapping
    String markShipping(@ModelAttribute("shippingNumber") ShippingNumber shippingNumber) {
        shippingService.markShipping(shippingNumber);
        return "redirect:/shipping/instructions";
    }

    @InitBinder({"shippingNumber"})
    void bindOrderItem(WebDataBinder binder) {
        binder.setAllowedFields(
                "value"
        );
    }
}
