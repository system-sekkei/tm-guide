package guide.tm.domain.model.invoice;

import guide.tm.domain.model.customer.CustomerId;

/**
 * 請求内容
 */
public class InvoiceContent {
    CustomerId customerId;
    InvoiceDate invoiceDate;
    OrderedYearMonth orderedYearMonth;

    public CustomerId customerId() {
        return customerId;
    }

    public InvoiceDate invoiceDate() {
        return invoiceDate;
    }

    public OrderedYearMonth orderedYearMonth() {
        return orderedYearMonth;
    }
}
