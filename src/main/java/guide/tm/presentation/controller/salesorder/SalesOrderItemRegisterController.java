package guide.tm.presentation.controller.salesorder;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.product.single.ProductService;
import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sales-orders/{salesOrderId}/items")
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
    SalesOrder salesOrder(@PathVariable("salesOrderId") SalesOrderId salesOrderId) {
        return salesOrderScenario.salesOrderOf(salesOrderId);
    }

    /**
     * 受注明細の登録
     */
    @PostMapping
    String newSalesItem(
            @PathVariable("salesOrderId") SalesOrderId salesOrderId,
            @ModelAttribute("salesOrderItemRequest") @Validated SalesOrderItemRequest salesOrderItemRequest,
            BindingResult salesOrderItemRequestResult
    ) {

        if (salesOrderItemRequestResult.hasErrors()) {
            return "sales-order/sales-order";
        }

        salesOrderItemService.register(salesOrderId, salesOrderItemRequest);
        return String.format("redirect:/sales-orders/%s", salesOrderId);
    }

    @InitBinder({"salesOrderItemRequest"})
    void bindOrderItem(WebDataBinder binder) {
        binder.setAllowedFields(
                "productName.value",
                "productCode.value",
                "quantity.value",
                "productType"
        );
    }

    @PostMapping("single/{salesOrderItemNumber}")
    String deleteSingleOrderItem(
            @PathVariable("salesOrderId") SalesOrderId salesOrderId,
            @PathVariable("salesOrderItemNumber") SalesOrderItemNumber salesOrderItemNumber
    ) {
        salesOrderItemService.deleteSingleOrderItem(salesOrderId, salesOrderItemNumber);
        return "redirect:/sales-orders/{salesOrderId}";
    }
}
