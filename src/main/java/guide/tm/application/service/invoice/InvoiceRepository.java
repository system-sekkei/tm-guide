package guide.tm.application.service.invoice;

import guide.tm.domain.model.invoice.InvoiceSummaries;

public interface InvoiceRepository {


    InvoiceSummaries invoiceSummariesOf(InvoiceRepository invoiceRepository);
}
