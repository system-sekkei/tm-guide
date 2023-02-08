package guide.tm.presentation.controller.salesorder;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.product.bundle.BundleProductService;
import guide.tm.application.service.product.individual.ProductService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.product.bundle.BundleProducts;
import guide.tm.domain.model.product.individual.IndividualProducts;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sales-orders")
class SalesOrderController {

    SalesOrderScenario salesOrderScenario;
    SalesOrderService salesOrderService;
    ProductService productService;
    BundleProductService bundleProductService;

    SalesOrderController(SalesOrderScenario salesOrderScenario, SalesOrderService salesOrderService, ProductService productService, BundleProductService bundleProductService) {
        this.salesOrderScenario = salesOrderScenario;
        this.salesOrderService = salesOrderService;
        this.productService = productService;
        this.bundleProductService = bundleProductService;
    }

    @GetMapping
    String salesOrderList(Model model) {
        SalesOrderSummaries salesOrderSummaries = salesOrderService.salesOrderSummaries();
        model.addAttribute("salesOrderSummaries", salesOrderSummaries);
        return "sales-order/sales-order-list";
    }


    @ModelAttribute("salesOrderItem")
    SalesOrderItem salesOrderItem() {
        return new SalesOrderItem();
    }

    @GetMapping("{salesOrderNumber}")
    String salesOrder(@PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
                      Model model) {
        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
        model.addAttribute("salesOrder", salesOrder);
        IndividualProducts individualProducts = productService.products();
        model.addAttribute("products", individualProducts);
        BundleProducts bundleProducts = bundleProductService.bundleProducts();
        model.addAttribute("bundleProducts", bundleProducts);
        return "sales-order/sales-order";
    }

}
