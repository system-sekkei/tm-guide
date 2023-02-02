package guide.tm.presentation.controller.salesorder;

import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sales-orders")
class SalesOrderController {

    SalesOrderService salesOrderService;

    SalesOrderItemService salesOrderItemService;

    SalesOrderController(SalesOrderService salesOrderService, SalesOrderItemService salesOrderItemService) {
        this.salesOrderService = salesOrderService;
        this.salesOrderItemService = salesOrderItemService;
    }

    @GetMapping
    String salesOrderList(Model model) {
        SalesOrderSummaries salesOrderSummaries = salesOrderService.salesOrderSummaries();
        model.addAttribute("salesOrderSummaries", salesOrderSummaries);
        return "sales-order/sales-order-list";
    }

    @GetMapping("{salesOrderNumber}")
    String salesOrder(@PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
                      Model model) {
        SalesOrderContent salesOrder = salesOrderService.salesOrderOf(salesOrderNumber);
        SalesOrderItems salesOrderItems = salesOrderItemService.salesOrderItemsOf(salesOrderNumber);
        model.addAttribute("salesOrder", salesOrder);
        model.addAttribute("salesOrderItems", salesOrderItems);
        return "sales-order/sales-order";
    }
}
