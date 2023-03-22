package guide.tm.presentation.controller.shipping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shipping-list")
class ShippingListController {

    @GetMapping
    String shippingList() {
        return "shipping/shipping-list";
    }
}
