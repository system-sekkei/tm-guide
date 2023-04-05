package guide.tm.application.service.invoice;

import guide.tm.domain.model.invoice.InvoiceSearchCriteria;
import guide.tm.domain.model.invoice.InvoiceSummaries;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    InvoiceRepository invoiceRepository;

    InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public InvoiceSummaries invoiceSummariesOf(InvoiceSearchCriteria invoiceSearchCriteria) {
        return invoiceRepository.invoiceSummariesOf(invoiceRepository);
    }
}
