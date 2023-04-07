package guide.tm.domain.model.invoice;

import guide.tm.domain.model.customer.CustomerId;
import jakarta.validation.constraints.AssertFalse;

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

    @AssertFalse(message = "請求日を入力してください")
    boolean isInvoiceDateEmpty() {
        return invoiceDate.isEmpty();
    }
}
