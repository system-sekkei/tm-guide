package guide.tm.presentation.controller.salesorder;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.customer.CustomerService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.customer.CustomerSummaries;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.tax.context.TaxContext;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.model.tax.context.TaxSumType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("sales-orders")
class SalesOrderController {

    SalesOrderScenario salesOrderScenario;
    SalesOrderService salesOrderService;
    CustomerService customerService;

    SalesOrderController(SalesOrderScenario salesOrderScenario, SalesOrderService salesOrderService, CustomerService customerService) {
        this.salesOrderScenario = salesOrderScenario;
        this.salesOrderService = salesOrderService;
        this.customerService = customerService;
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
        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
        model.addAttribute("salesOrder", salesOrder);
        return "sales-order/sales-order";
    }

    @GetMapping("new")
    String newSalesOrder(Model model) {
        CustomerSummaries customerSummaries = customerService.customerSummaries();
        model.addAttribute("customerSummaries", customerSummaries);
        model.addAttribute("taxRateTypes", TaxRateType.values());
        model.addAttribute("taxSumTypes", TaxSumType.values());
        return "sales-order/sales-order-new";
    }

    /**
     * 受注の登録
     */
    @PostMapping("new")
    String register(@ModelAttribute("salesOrderContent") @Validated SalesOrderContent salesOrderContent,
                    BindingResult salesOrderContentResult,
                    @ModelAttribute("taxContext") @Validated TaxContext taxContext,
                    BindingResult taxContextResult,
                    UriComponentsBuilder uriComponentsBuilder,
                    Model model) {
        SalesOrderNumber salesOrderNumber = salesOrderService.registerSalesOrder(salesOrderContent);
        salesOrderService.registerTax(taxContext, salesOrderNumber);

        URI location = uriComponentsBuilder.path(String.format("/sales-orders/%s", salesOrderNumber.toString())).build().toUri();
        return "redirect:" + location;
    }

    @InitBinder("taxContext")
    public void bindTaxContext(WebDataBinder binder) {
        binder.setAllowedFields(
                "taxRateType",
                "taxSumType"
        );
    }

    @InitBinder("salesOrderContent")
    public void bindSalesOrderContent(WebDataBinder binder) {
        binder.setAllowedFields(
                "customer.code.value",
                "orderedDate.value"
        );
    }
}
