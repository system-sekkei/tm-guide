package guide.tm.infrastructure.datasource.invoice;

import guide.tm.application.service.invoice.InvoiceRepository;
import guide.tm.domain.model.invoice.InvoiceSummaries;
import guide.tm.domain.model.invoice.InvoiceSummary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceDataSource implements InvoiceRepository {

    InvoiceMapper invoiceMapper;

    InvoiceDataSource(InvoiceMapper invoiceMapper) {
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceSummaries invoiceSummariesOf(InvoiceRepository invoiceRepository) {
        List<InvoiceSummary> invoiced = invoiceMapper.invoicedSummaries(invoiceRepository);
        List<InvoiceSummary> notInvoiced = invoiceMapper.notInvoicedSummaries(invoiceRepository);

        List<InvoiceSummary> result = new ArrayList<>();
        result.addAll(invoiced);
        result.addAll(notInvoiced);

        return new InvoiceSummaries(result);
    }
}
