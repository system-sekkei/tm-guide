package guide.tm.infrastructure.datasource.invoice;

import guide.tm.application.service.invoice.InvoiceRepository;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.*;
import guide.tm.domain.model.salesorder.order.SalesOrders;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class InvoiceDataSource implements InvoiceRepository {

    InvoiceMapper invoiceMapper;

    InvoiceDataSource(InvoiceMapper invoiceMapper) {
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceSummaries invoiceSummariesOf(InvoiceSearchCriteria invoiceSearchCriteria) {
        List<InvoiceSummary> invoiced = invoiceMapper.invoicedSummaries(invoiceSearchCriteria);
        List<InvoiceSummary> notInvoiced = invoiceMapper.notInvoicedSummaries(invoiceSearchCriteria);

        List<InvoiceSummary> result = new ArrayList<>();
        result.addAll(invoiced);
        result.addAll(notInvoiced);

        return new InvoiceSummaries(result);
    }

    @Override
    public void register(CustomerId customerId, OrderedYearMonth orderedYearMonth, InvoiceDate invoiceDate, SalesOrders salesOrders) {
        UUID invoiceId = UUID.randomUUID();
        InvoiceNumber invoiceNumber = new InvoiceNumber(String.valueOf(invoiceMapper.newInvoiceNumber()));
        invoiceMapper.register(invoiceId, invoiceNumber, customerId, orderedYearMonth.startOfOrderedYearMonth(), invoiceDate);
        salesOrders.list().forEach(salesOrder -> invoiceMapper.registerInvoicedSalesOrder(invoiceId, salesOrder));
    }
}
