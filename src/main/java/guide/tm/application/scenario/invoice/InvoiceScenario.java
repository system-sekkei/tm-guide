package guide.tm.application.scenario.invoice;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.invoice.InvoiceService;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.InvoiceDate;
import guide.tm.domain.model.invoice.OrderedYearMonth;
import guide.tm.domain.model.salesorder.order.SalesOrders;
import org.springframework.stereotype.Service;

@Service
public class InvoiceScenario {

    SalesOrderScenario salesOrderScenario;
    InvoiceService invoiceService;

    public void register(CustomerId customerId, OrderedYearMonth orderedYearMonth, InvoiceDate invoiceDate) {
        SalesOrders salesOrders = salesOrderScenario.salesOrdersOf(customerId, orderedYearMonth);
        invoiceService.register(customerId, orderedYearMonth, invoiceDate, salesOrders);
    }

}
