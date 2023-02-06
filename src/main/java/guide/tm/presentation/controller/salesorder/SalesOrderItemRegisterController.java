package guide.tm.presentation.controller.salesorder;

import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sales-orders/{salesOrderNumber}/items")
class SalesOrderItemRegisterController {

    SalesOrderItemService salesOrderItemService;

    SalesOrderItemRegisterController(SalesOrderItemService salesOrderItemService) {
        this.salesOrderItemService = salesOrderItemService;
    }

    /**
     * 受注明細の登録
     */
    @PostMapping("new")
    String register(
            @PathVariable("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @ModelAttribute("salesOrderItem") @Validated SalesOrderItem salesOrderItem,
                    BindingResult salesOrderItemResult,
                    Model model) {

        salesOrderItemService.register(salesOrderNumber, salesOrderItem);
        return String.format("redirect:/sales-orders/%s", salesOrderNumber);
    }

    @InitBinder("salesOrderItem")
    public void bindTaxContext(WebDataBinder binder) {
        binder.setAllowedFields(
                "product.code.value",
                "quantity.value"
        );
    }

}
