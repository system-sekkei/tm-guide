package guide.tm.presentation.controller.invoice;

import guide.tm.application.service.invoice.InvoiceService;
import guide.tm.domain.model.invoice.InvoiceSearchCriteria;
import guide.tm.domain.model.invoice.InvoiceSummaries;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("invoices")
class InvoiceController {

    InvoiceService invoiceService;

    InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
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
}
