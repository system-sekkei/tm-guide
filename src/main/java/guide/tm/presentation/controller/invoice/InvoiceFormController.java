package guide.tm.presentation.controller.invoice;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.InvoiceContent;
import guide.tm.domain.model.invoice.OrderedYearMonth;
import guide.tm.domain.model.salesorder.order.SalesOrders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("invoice")
class InvoiceFormController {

    SalesOrderScenario salesOrderScenario;

    InvoiceFormController(SalesOrderScenario salesOrderScenario) {
        this.salesOrderScenario = salesOrderScenario;
    }

    @ModelAttribute
    InvoiceContent invoiceContent() {
        return new InvoiceContent();
    }

    @GetMapping
    String forInvoice(
            @RequestParam("customerId") CustomerId customerId,
            @RequestParam("orderedYearMonth") OrderedYearMonth orderedYearMonth,
            Model model) {

        SalesOrders salesOrders = salesOrderScenario.salesOrdersOf(customerId, orderedYearMonth);
        model.addAttribute("salesOrders", salesOrders);
        model.addAttribute("orderedYearMonth", orderedYearMonth);
        return "invoice/new-invoice";
    }
}
