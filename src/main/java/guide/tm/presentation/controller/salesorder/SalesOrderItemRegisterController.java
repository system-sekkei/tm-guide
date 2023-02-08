package guide.tm.presentation.controller.salesorder;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.product.bundle.BundleProductService;
import guide.tm.application.service.product.individual.ProductService;
import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.domain.model.product.bundle.BundleProducts;
import guide.tm.domain.model.product.individual.IndividualProducts;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sales-orders/{salesOrderNumber}/items")
class SalesOrderItemRegisterController {

    SalesOrderScenario salesOrderScenario;
    ProductService productService;
    SalesOrderItemService salesOrderItemService;
    BundleProductService bundleProductService;

    SalesOrderItemRegisterController(
            SalesOrderScenario salesOrderScenario,
            ProductService productService,
            SalesOrderItemService salesOrderItemService,
            BundleProductService bundleProductService) {
        this.salesOrderScenario = salesOrderScenario;
        this.productService = productService;
        this.salesOrderItemService = salesOrderItemService;
        this.bundleProductService = bundleProductService;
    }

    @ModelAttribute("salesOrderItem")
    SalesOrderItem salesOrderItem() {
        return new SalesOrderItem();
    }

    /**
     * 受注明細の登録
     */
    @PostMapping("new")
    String register(
            @PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @ModelAttribute("salesOrderItemContent") @Validated SalesOrderItemContent salesOrderItemContent,
                    BindingResult salesOrderItemResult,
                    Model model) {

        if (salesOrderItemResult.hasErrors()) {
            SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
            model.addAttribute("salesOrder", salesOrder);
            IndividualProducts individualProducts = productService.products();
            model.addAttribute("products", individualProducts);
            BundleProducts bundleProducts = bundleProductService.bundleProducts();
            model.addAttribute("bundleProducts", bundleProducts);
            return "sales-order/sales-order";
        }

        salesOrderItemService.register(salesOrderNumber, salesOrderItemContent);
        return String.format("redirect:/sales-orders/%s", salesOrderNumber);
    }

    /**
     * 受注明細の登録
     */
    @PostMapping("new-bundle")
    String registerBundle(
            @PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @ModelAttribute("salesOrderItemContent") @Validated SalesOrderItemContent salesOrderItemContent,
            BindingResult salesOrderItemResult,
            Model model) {

        if (salesOrderItemResult.hasErrors()) {
            SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
            model.addAttribute("salesOrder", salesOrder);
            IndividualProducts individualProducts = productService.products();
            model.addAttribute("products", individualProducts);
            BundleProducts bundleProducts = bundleProductService.bundleProducts();
            model.addAttribute("bundleProducts", bundleProducts);
            return "sales-order/sales-order";
        }

        salesOrderItemService.register(salesOrderNumber, salesOrderItemContent);
        return String.format("redirect:/sales-orders/%s", salesOrderNumber);
    }

    @InitBinder("salesOrderItemContent")
    public void bindTaxContext(WebDataBinder binder) {
        binder.setAllowedFields(
                "product.code.value",
                "quantity.value"
        );
    }

}
