package guide.tm.presentation.controller.shipping;

import guide.tm.application.scenario.shipping.ShippingScenario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shipping/sales-order/{salesOrderNumber}")
class ShippingController {

    ShippingScenario shippingScenario;

    ShippingController(ShippingScenario shippingScenario) {
        this.shippingScenario = shippingScenario;
    }

//    @PostMapping
//    String registerShipping(@PathVariable SalesOrderNumber salesOrderNumber) {
//        shippingScenario.registerShippingOf(salesOrderNumber);
//        return "redirect:/sales-orders/{salesOrderNumber}/allocations";
//    }

}
