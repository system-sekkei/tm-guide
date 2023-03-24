package guide.tm.presentation.controller.shipping;

import guide.tm.application.scenario.shipping.ShippingScenario;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("shipping/sales-order/{salesOrderId}")
class ShippingController {

    ShippingScenario shippingScenario;

    ShippingController(ShippingScenario shippingScenario) {
        this.shippingScenario = shippingScenario;
    }

    @PostMapping
    String registerShipping(
            @PathVariable("salesOrderId") SalesOrderId salesOrderId,
            RedirectAttributes redirectAttributes) {
        shippingScenario.registerShippingOf(salesOrderId);
        redirectAttributes.addFlashAttribute("message", "出荷指示を登録しました");
        return "redirect:/sales-orders/{salesOrderNumber}/allocations";
    }

}
