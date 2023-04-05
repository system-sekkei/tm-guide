package guide.tm.domain.model.invoice;

import guide.tm.domain.model.customer.Customer;

/**
 * 請求
 */
public class Invoice {
    InvoiceNumber invoiceNumber;
    Customer customer;

    InvoicedSalesOrders invoicedSalesOrders;

}
