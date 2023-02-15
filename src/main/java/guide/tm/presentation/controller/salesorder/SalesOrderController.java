package guide.tm.presentation.controller.salesorder;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.product.bundle.BundleProductService;
import guide.tm.application.service.product.individual.ProductService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.salesorder.SalesOrderAllocation;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.product.bundle.BundleProducts;
import guide.tm.domain.model.product.individual.IndividualProducts;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemContent;
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
    AllocationService allocationService;
    ShippingItemService shippingItemService;

    SalesOrderController(
            SalesOrderScenario salesOrderScenario,
            SalesOrderService salesOrderService,
            ProductService productService,
            BundleProductService bundleProductService,
            AllocationService allocationService,
            ShippingItemService shippingItemService) {
        this.salesOrderScenario = salesOrderScenario;
        this.salesOrderService = salesOrderService;
        this.productService = productService;
        this.bundleProductService = bundleProductService;
        this.allocationService = allocationService;
        this.shippingItemService = shippingItemService;
    }

    @GetMapping
    String salesOrderList(Model model) {
        SalesOrderSummaries salesOrderSummaries = salesOrderService.salesOrderSummaries();
        model.addAttribute("salesOrderSummaries", salesOrderSummaries);
        return "sales-order/sales-order-list";
    }

    @ModelAttribute("salesOrderItemContent")
    SalesOrderItemContent salesOrderItemContent() {
        return new SalesOrderItemContent();
    }

    @ModelAttribute("bundleProductOrderItemContent")
    BundleProductOrderItemContent bundleProductOrderItemContent() {
        return new BundleProductOrderItemContent();
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

    @GetMapping("{salesOrderNumber}/allocations")
    String allocations(@PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
                       Model model) {
        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
        model.addAttribute("salesOrder", salesOrder);

        SingleAllocations singleAllocations = allocationService.singleAllocationsOf(salesOrderNumber);
        BundleAllocations bundleAllocations = allocationService.bundleAllocations(salesOrderNumber);

        model.addAttribute("salesOrderAllocation", new SalesOrderAllocation(salesOrderNumber, salesOrder, singleAllocations, bundleAllocations));
//////        ShippingItems shippingItems = shippingItemService.shippingItems(salesOrderNumber);
//////        model.addAttribute("shippingItems", shippingItems);
        return "sales-order/allocations";
    }

}
