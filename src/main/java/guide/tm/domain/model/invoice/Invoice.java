package guide.tm.domain.model.invoice;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.salesorder.order.SalesOrders;

/**
 * 請求
 */
public class Invoice {
    InvoiceDetail invoiceDetail;
    Customer customer;
    SalesOrders salesOrders;

    @Deprecated
    Invoice() {
    }

    public Invoice(InvoiceDetail invoiceDetail, Customer customer, SalesOrders salesOrders) {
        this.invoiceDetail = invoiceDetail;
        this.customer = customer;
        this.salesOrders = salesOrders;
    }

    public InvoiceNumber invoiceNumber() {
        return invoiceDetail.invoiceNumber;
    }

    public Customer customer() {
        return customer;
    }

    public InvoiceDate invoiceDate() {
        return invoiceDetail.invoiceDate;
    }

    public OrderedYearMonth orderedYearMonth() {
        return invoiceDetail.orderedYearMonth;
    }

    public SalesOrders salesOrders() {
        return salesOrders;
    }
}
