package guide.tm.presentation.controller.invoice;

import guide.tm.application.scenario.invoice.InvoiceScenario;
import guide.tm.application.service.invoice.InvoiceService;
import guide.tm.domain.model.invoice.InvoiceContent;
import guide.tm.domain.model.invoice.InvoiceSearchCriteria;
import guide.tm.domain.model.invoice.InvoiceSummaries;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("invoices")
class InvoiceController {

    InvoiceScenario invoiceScenario;
    InvoiceService invoiceService;

    InvoiceController(InvoiceScenario invoiceScenario, InvoiceService invoiceService) {
        this.invoiceScenario = invoiceScenario;
        this.invoiceService = invoiceService;
    }

    @PostMapping
    String register(@ModelAttribute("invoiceContent") InvoiceContent invoiceContent,
                    Model model) {
//        invoiceScenario.register(invoiceContent);
        return "redirect:/invoices";
    }

    @GetMapping
    String list(@ModelAttribute InvoiceSearchCriteria invoiceSearchCriteria,
                Model model) {

        InvoiceSummaries invoiceSummaries = invoiceService.invoiceSummariesOf(invoiceSearchCriteria);
        model.addAttribute("invoiceSummaries", invoiceSummaries);

        return "invoice/invoices";
    }

    @GetMapping("{invoiceId}")
    String detail(@PathVariable String invoiceId) {
        return "invoice/invoice";
    }

    @InitBinder("invoiceContent")
    void bindInvoiceContent(WebDataBinder binder) {
        binder.setAllowedFields(
                "invoiceDate.value",
//                "OrderedYearMonth",
                "orderedYearMonth",
                "customerId.value"
        );
    }
}
