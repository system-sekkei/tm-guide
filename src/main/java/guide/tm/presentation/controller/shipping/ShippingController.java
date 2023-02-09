package guide.tm.presentation.controller.shipping;

import guide.tm.application.service.shipping.ShippingService;
import guide.tm.domain.model.customer.CustomerNumber;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shipping/customer/{customerNumber}")
class ShippingController {

    ShippingService shippingService;

    @PostMapping
    String registerShipping(@PathVariable CustomerNumber customerNumber) {

        return "redirect:customers/sales-orders";
    }
}
