package guide.tm.infrastructure.datasource.invoice;

import guide.tm.application.service.invoice.InvoiceRepository;
import guide.tm.domain.model.invoice.*;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderIdList;
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
    public void register(InvoiceContent invoiceContent, SalesOrders salesOrders) {
        UUID invoiceId = UUID.randomUUID();
        InvoiceNumber invoiceNumber = new InvoiceNumber(String.valueOf(invoiceMapper.newInvoiceNumber()));
        invoiceMapper.register(invoiceId, invoiceNumber, invoiceContent.customerId(), invoiceContent.orderedYearMonth().startOfOrderedYearMonth(), invoiceContent.invoiceDate());
        salesOrders.list().forEach(salesOrder -> {
            invoiceMapper.registerInvoicedSalesOrder(invoiceId, salesOrder);
            invoiceMapper.deleteUnInvoicedSalesOrder(salesOrder.salesOrderId());
        });
    }

    @Override
    public InvoiceDetail invoiceDetailOf(InvoiceId invoiceId) {
        InvoiceDetail invoiceDetail = invoiceMapper.invoiceDetailOf(invoiceId);
        return invoiceDetail;
    }

    @Override
    public SalesOrderIdList salesOrderIdsOf(InvoiceId invoiceId) {
        SalesOrderIdList salesOrderIdList = new SalesOrderIdList(invoiceMapper.salesOrderIdListOf(invoiceId));
        return salesOrderIdList;
    }

    @Override
    public void recordUnInvoiced(SalesOrderId salesOrderId) {
        invoiceMapper.recordUnInvoiced(salesOrderId);
    }
}
