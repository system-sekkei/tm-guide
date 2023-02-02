package guide.tm.presentation.controller.salesorder;

import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sales-orders")
class SalesOrderController {

    SalesOrderService salesOrderService;

    SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @GetMapping
    String salesOrderList(Model model) {

        SalesOrderSummaries salesOrderSummaries = salesOrderService.salesOrderSummaries();
        model.addAttribute("salesOrderSummaries", salesOrderSummaries);
        return "sales-order/sales-order-list";
    }
}
