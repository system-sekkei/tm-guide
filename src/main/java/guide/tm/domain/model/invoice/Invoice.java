package guide.tm.domain.model.invoice;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.salesorder.order.SalesOrders;

/**
 * 請求
 */
public class Invoice {
    InvoiceNumber invoiceNumber;
    Customer customer;
    InvoiceDate invoiceDate;
    OrderedYearMonth orderedYearMonth;
    SalesOrders salesOrders;

    public Invoice(InvoiceNumber invoiceNumber, Customer customer, InvoiceDate invoiceDate, OrderedYearMonth orderedYearMonth, SalesOrders salesOrders) {
        this.invoiceNumber = invoiceNumber;
        this.customer = customer;
        this.invoiceDate = invoiceDate;
        this.orderedYearMonth = orderedYearMonth;
        this.salesOrders = salesOrders;
    }
}
