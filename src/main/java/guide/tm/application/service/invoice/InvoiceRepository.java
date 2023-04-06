package guide.tm.application.service.invoice;

import guide.tm.domain.model.invoice.*;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderIdList;
import guide.tm.domain.model.salesorder.order.SalesOrders;

public interface InvoiceRepository {


    InvoiceSummaries invoiceSummariesOf(InvoiceSearchCriteria invoiceSearchCriteria);

    void register(InvoiceContent invoiceContent, SalesOrders salesOrders);

    InvoiceDetail invoiceDetailOf(InvoiceId invoiceId);

    SalesOrderIdList salesOrderIdsOf(InvoiceId invoiceId);

    void recordUnInvoiced(SalesOrderId salesOrderId);
}
