package guide.tm.domain.model.invoice;

import guide.tm.domain.model.customer.CustomerId;

/**
 * 請求詳細
 */
public class InvoiceDetail {
    InvoiceNumber invoiceNumber;
    InvoiceDate invoiceDate;
    OrderedYearMonth orderedYearMonth;
    CustomerId customerId;

    public OrderedYearMonth orderedYearMonth() {
        return orderedYearMonth;
    }

    public CustomerId customerId() {
        return customerId;
    }
}
