package guide.tm.domain.model.invoice;

import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.customer.CustomerName;
import guide.tm.domain.model.salesorder.content.OrderedDate;

/**
 * 請求サマリー
 */
public class InvoiceSummary {

    InvoiceId invoiceId;
    InvoiceNumber invoiceNumber;

    InvoiceDate invoiceDate;

    CustomerId customerId;
    CustomerName customerName;

    OrderedYearMonth orderedYearMonth;

    InvoiceStatus invoiceStatus;


    public InvoiceId invoiceId() {
        return invoiceId;
    }

    public InvoiceNumber invoiceNumber() {
        return invoiceNumber;
    }

    public InvoiceDate invoiceDate() {
        return invoiceDate;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public CustomerName customerName() {
        return customerName;
    }

    public OrderedYearMonth orderedYearMonth() {
        return orderedYearMonth;
    }

    public OrderedDate startOfOrderedYearMonth() {
        return orderedYearMonth.startOfOrderedYearMonth();
    }

    public OrderedDate endOfOrderedYearMonth() {
        return orderedYearMonth.endOfOrderedYearMonth();
    }

    public InvoiceStatus invoiceStatus() {
        return invoiceStatus;
    }
}
