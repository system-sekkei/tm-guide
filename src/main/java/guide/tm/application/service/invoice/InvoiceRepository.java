package guide.tm.application.service.invoice;

import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.InvoiceDate;
import guide.tm.domain.model.invoice.InvoiceSearchCriteria;
import guide.tm.domain.model.invoice.InvoiceSummaries;
import guide.tm.domain.model.invoice.OrderedYearMonth;
import guide.tm.domain.model.salesorder.order.SalesOrders;

public interface InvoiceRepository {


    InvoiceSummaries invoiceSummariesOf(InvoiceSearchCriteria invoiceSearchCriteria);

    void register(CustomerId customerId, OrderedYearMonth orderedYearMonth, InvoiceDate invoiceDate, SalesOrders salesOrders);
}
