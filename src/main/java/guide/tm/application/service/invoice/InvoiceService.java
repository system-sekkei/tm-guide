package guide.tm.application.service.invoice;

import guide.tm.domain.model.invoice.*;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderIdList;
import guide.tm.domain.model.salesorder.order.SalesOrders;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    InvoiceRepository invoiceRepository;

    InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * 請求一覧を取得する
     */
    public InvoiceSummaries invoiceSummariesOf(InvoiceSearchCriteria invoiceSearchCriteria) {
        return invoiceRepository.invoiceSummariesOf(invoiceSearchCriteria);
    }

    /**
     * 請求を登録する
     */
    public void register(InvoiceContent invoiceContent, SalesOrders salesOrders) {
        invoiceRepository.register(invoiceContent, salesOrders);
    }

    /**
     * 請求を取得する
     */
    public InvoiceDetail invoiceDetailOf(InvoiceId invoiceId) {
        return invoiceRepository.invoiceDetailOf(invoiceId);
    }

    /**
     * 請求済の受注リストを取得する
     */
    public SalesOrderIdList salesOrderIdsOf(InvoiceId invoiceId) {
        return invoiceRepository.salesOrderIdsOf(invoiceId);
    }

    public void recordUnInvoiced(SalesOrderId salesOrderId) {
        invoiceRepository.recordUnInvoiced(salesOrderId);
    }
}
