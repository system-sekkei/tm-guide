package guide.tm.presentation.controller.invoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("invoices")
class InvoiceController {
    @GetMapping
    String list() {
        return "invoice/invoices";
    }

    @GetMapping("{invoiceId}")
    String detail(@PathVariable String invoiceId) {
        return "invoice/invoice";
    }
}
