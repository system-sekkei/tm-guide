package guide.tm.presentation.controller.shipping;

import guide.tm.application.scenario.shipping.ShippingScenario;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("shipping/sales-order/{salesOrderNumber}")
class ShippingController {

    ShippingScenario shippingScenario;

    ShippingController(ShippingScenario shippingScenario) {
        this.shippingScenario = shippingScenario;
    }

    @PostMapping
    String registerShipping(
            @PathVariable SalesOrderNumber salesOrderNumber,
            RedirectAttributes redirectAttributes) {
        shippingScenario.registerShippingOf(salesOrderNumber);
        redirectAttributes.addFlashAttribute("message", "出荷指示を登録しました");
        return "redirect:/sales-orders/{salesOrderNumber}/allocations";
    }

}
