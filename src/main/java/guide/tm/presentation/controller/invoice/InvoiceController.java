package guide.tm.presentation.controller.invoice;

import guide.tm.application.scenario.invoice.InvoiceScenario;
import guide.tm.application.service.invoice.InvoiceService;
import guide.tm.domain.model.invoice.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    String register(@Validated @ModelAttribute("invoiceContent") InvoiceContent invoiceContent,
                    BindingResult bindingResult,
                    RedirectAttributes redirectAttributes,
                    Model model) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addAttribute("customerId", invoiceContent.customerId());
            redirectAttributes.addAttribute("orderedYearMonth", invoiceContent.orderedYearMonth());
            redirectAttributes.addFlashAttribute("invoiceContent", invoiceContent);
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "invoiceContent", bindingResult);
            return "redirect:/invoice";
        }
        invoiceScenario.register(invoiceContent);
        return "redirect:/invoices";
    }

    @GetMapping
    String list(@ModelAttribute("invoiceSearchCriteria") InvoiceSearchCriteria invoiceSearchCriteria,
                Model model) {

        InvoiceSummaries invoiceSummaries = invoiceService.invoiceSummariesOf(invoiceSearchCriteria);
        model.addAttribute("invoiceSummaries", invoiceSummaries);
        model.addAttribute("invoiceStatuses", InvoiceStatus.values());

        return "invoice/invoices";
    }

    @GetMapping("{invoiceId}")
    String detail(@PathVariable("invoiceId") InvoiceId invoiceId,
                  Model model) {
        Invoice invoice = invoiceScenario.invoiceOf(invoiceId);
        model.addAttribute("invoice", invoice);
        return "invoice/invoice";
    }

    @InitBinder("invoiceContent")
    void bindInvoiceContent(WebDataBinder binder) {
        binder.setAllowedFields(
                "invoiceDate.value",
                "orderedYearMonth",
                "customerId.value"
        );
    }

    @InitBinder("invoiceSearchCriteria")
    void bindInvoiceSearchCriteria(WebDataBinder binder) {
        binder.setAllowedFields(
                "invoiceStatusList",
                "from.value",
                "to.value"
        );
    }
}
