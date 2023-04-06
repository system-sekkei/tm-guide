package guide.tm.infrastructure.datasource.invoice;

import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.*;
import guide.tm.domain.model.salesorder.content.OrderedDate;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface InvoiceMapper {

    List<InvoiceSummary> invoicedSummaries(
            @Param("invoiceSearchCriteria") InvoiceSearchCriteria invoiceSearchCriteria);

    List<InvoiceSummary> notInvoicedSummaries(
            @Param("invoiceSearchCriteria") InvoiceSearchCriteria invoiceSearchCriteria);

    void register(
            @Param("invoiceId") UUID invoiceId,
            @Param("invoiceNumber") InvoiceNumber invoiceNumber,
            @Param("customerId") CustomerId customerId,
            @Param("orderedYearMonth") OrderedDate orderedYearMonth,
            @Param("invoiceDate") InvoiceDate invoiceDate);

    long newInvoiceNumber();

    void registerInvoicedSalesOrder(
            @Param("invoiceId") UUID invoiceId,
            @Param("salesOrder") SalesOrder salesOrder);

    InvoiceDetail invoiceDetailOf(
            @Param("invoiceId") InvoiceId invoiceId);

    List<SalesOrderId> salesOrderIdListOf(
            @Param("invoiceId") InvoiceId invoiceId);

    void recordUnInvoiced(
            @Param("salesOrderId") SalesOrderId salesOrderId);

    void deleteUnInvoicedSalesOrder(
            @Param("salesOrderId") SalesOrderId salesOrderId);
}
