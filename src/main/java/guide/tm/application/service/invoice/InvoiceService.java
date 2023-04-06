package guide.tm.application.service.invoice;

import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.InvoiceDate;
import guide.tm.domain.model.invoice.InvoiceSearchCriteria;
import guide.tm.domain.model.invoice.InvoiceSummaries;
import guide.tm.domain.model.invoice.OrderedYearMonth;
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
    public void register(CustomerId customerId, OrderedYearMonth orderedYearMonth, InvoiceDate invoiceDate, SalesOrders salesOrders) {
        invoiceRepository.register(customerId, orderedYearMonth, invoiceDate, salesOrders);
    }
}
