package guide.tm.presentation.controller.salesorder.customer;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.domain.model.salesorder.order.CustomerSalesOrders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class CustomerSalesOrderController {

    SalesOrderScenario salesOrderScenario;

    CustomerSalesOrderController(SalesOrderScenario salesOrderScenario) {
        this.salesOrderScenario = salesOrderScenario;
    }
    @GetMapping("customers/sales-orders")
    String customers(Model model) {
        CustomerSalesOrders customerSalesOrders = salesOrderScenario.customerSalesOrders();
        model.addAttribute("customerSalesOrders", customerSalesOrders);
        return "sales-order/customer/customer-sales-order-list";
    }


//    @GetMapping("customers/{customerNumber}/sales-orders")
//    String customerSalesOrder(@PathVariable CustomerNumber customerNumber,
//                              Model model) {
//        SalesOrders salesOrders = salesOrderScenario.salesOrdersOf(customerNumber);
//        model.addAttribute("salesOrders", salesOrders);
//        return "sales-order/customer/customer-sales-orders";
//    }

}
