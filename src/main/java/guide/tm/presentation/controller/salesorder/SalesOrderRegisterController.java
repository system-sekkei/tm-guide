package guide.tm.presentation.controller.salesorder;

import guide.tm.application.service.customer.CustomerService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.customer.CustomerSummaries;
import guide.tm.domain.model.salesorder.content.Prefecture;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.tax.context.TaxContext;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.model.tax.context.TaxSumType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sales-orders")
class SalesOrderRegisterController {

    SalesOrderService salesOrderService;
    CustomerService customerService;

    public SalesOrderRegisterController(SalesOrderService salesOrderService, CustomerService customerService) {
        this.salesOrderService = salesOrderService;
        this.customerService = customerService;
    }

    @ModelAttribute("taxRateTypes")
    TaxRateType[] taxRateTypes() {
        return TaxRateType.values();
    }

    @ModelAttribute("taxSumTypes")
    TaxSumType[] taxSumTypes() {
        return TaxSumType.values();
    }

    @ModelAttribute("customerSummaries")
    CustomerSummaries customerSummaries() {
        return customerService.customerSummaries();
    }

    @ModelAttribute("prefectures")
    Prefecture[] prefectures() {
        return Prefecture.values();
    }

    @GetMapping("new")
    String newSalesOrder(Model model) {
        model.addAttribute("salesOrderContent", new SalesOrderContent());
        model.addAttribute("taxContext", new TaxContext());
        return "sales-order/sales-order-new";
    }

    /**
     * 受注の登録
     */
    @PostMapping("new")
    String register(@ModelAttribute("salesOrderContent") @Validated SalesOrderContent salesOrderContent,
                    BindingResult salesOrderContentResult,
                    @ModelAttribute("taxSumType") TaxSumType taxSumType,
                    BindingResult taxContextResult) {
        if (salesOrderContentResult.hasErrors() || taxContextResult.hasErrors()) {
            return "sales-order/sales-order-new";
        }

        SalesOrderNumber salesOrderNumber = salesOrderService.registerSalesOrder(salesOrderContent);
        salesOrderService.registerTax(taxSumType, salesOrderNumber);

        return String.format("redirect:/sales-orders/%s", salesOrderNumber);
    }

    @InitBinder("salesOrderContent")
    void bindSalesOrderContent(WebDataBinder binder) {
        binder.setAllowedFields(
                "customer.code.value",
                "customer.name.lastName",
                "customer.name.firstName",
                "shippingAddress.prefecture",
                "shippingAddress.addressLine",
                "orderedDate.value"
        );
    }
}
