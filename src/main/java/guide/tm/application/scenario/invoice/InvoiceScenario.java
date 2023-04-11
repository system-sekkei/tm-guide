package guide.tm.application.scenario.invoice;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.customer.CustomerService;
import guide.tm.application.service.invoice.InvoiceService;
import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.invoice.Invoice;
import guide.tm.domain.model.invoice.InvoiceContent;
import guide.tm.domain.model.invoice.InvoiceDetail;
import guide.tm.domain.model.invoice.InvoiceId;
import guide.tm.domain.model.salesorder.order.SalesOrderIdList;
import guide.tm.domain.model.salesorder.order.SalesOrders;
import org.springframework.stereotype.Service;

/**
 * 請求シナリオ
 */
@Service
public class InvoiceScenario {

    SalesOrderScenario salesOrderScenario;
    InvoiceService invoiceService;

    CustomerService customerService;

    InvoiceScenario(SalesOrderScenario salesOrderScenario, InvoiceService invoiceService, CustomerService customerService) {
        this.salesOrderScenario = salesOrderScenario;
        this.invoiceService = invoiceService;
        this.customerService = customerService;
    }

    /**
     * 請求を登録する
     *
     * 1. 請求対象の受注を取得する
     * 2. 請求を登録する
     */
    public void register(InvoiceContent invoiceContent) {
        SalesOrders salesOrders = salesOrderScenario.salesOrdersOf(invoiceContent.customerId(), invoiceContent.orderedYearMonth());
        invoiceService.register(invoiceContent, salesOrders);
    }

    /**
     * 請求を取得する
     */
    public Invoice invoiceOf(InvoiceId invoiceId) {
        InvoiceDetail invoiceDetail = invoiceService.invoiceDetailOf(invoiceId);
        Customer customer = customerService.customerOf(invoiceDetail.customerId());
        SalesOrderIdList salesOrderIdList = invoiceService.salesOrderIdsOf(invoiceId);
        SalesOrders salesOrders = salesOrderScenario.salesOrdersOf(salesOrderIdList);
        return new Invoice(invoiceDetail, customer, salesOrders);
    }
}
