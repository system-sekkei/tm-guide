package guide.tm.presentation.controller.salesorder;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.product.single.ProductService;
import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import org.springframework.stereotype.Controller;
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

    SalesOrderItemRegisterController(
            SalesOrderScenario salesOrderScenario,
            ProductService productService,
            SalesOrderItemService salesOrderItemService) {
        this.salesOrderScenario = salesOrderScenario;
        this.productService = productService;
        this.salesOrderItemService = salesOrderItemService;
    }

    @ModelAttribute("salesOrderItemRequest")
    SalesOrderItemRequest salesOrderItemRequest() {
        return new SalesOrderItemRequest();
    }

    @ModelAttribute("salesOrder")
    SalesOrder salesOrder(@PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber) {
        return salesOrderScenario.salesOrderOf(salesOrderNumber);
    }

    /**
     * 受注明細の登録
     */
    @PostMapping
    String newSalesItem(
            @PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @ModelAttribute("salesOrderItemRequest") @Validated SalesOrderItemRequest salesOrderItemRequest,
            BindingResult salesOrderItemRequestResult
    ) {

        if (salesOrderItemRequestResult.hasErrors()) {
            return "sales-order/sales-order";
        }

        salesOrderItemService.register(salesOrderNumber, salesOrderItemRequest);
        return String.format("redirect:/sales-orders/%s", salesOrderNumber);
    }

    @InitBinder({"salesOrderItemRequest"})
    void bindOrderItem(WebDataBinder binder) {
        binder.setAllowedFields(
                "productCode.value",
                "quantity.value",
                "productType"
        );
    }

}
