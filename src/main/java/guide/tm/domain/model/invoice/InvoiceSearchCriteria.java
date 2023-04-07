package guide.tm.domain.model.invoice;

import guide.tm.domain.model.salesorder.content.OrderedDate;

import java.util.Arrays;
import java.util.List;

/**
 * 請求検索条件
 */
public class InvoiceSearchCriteria {
    OrderedDate from;
    OrderedDate to;
    List<InvoiceStatus> invoiceStatusList;

    public InvoiceSearchCriteria() {
        this.from = new OrderedDate();
        this.to = new OrderedDate();
        this.invoiceStatusList = Arrays.asList(InvoiceStatus.未請求, InvoiceStatus.請求済);;
    }

    public OrderedDate from() {
        return from;
    }

    public OrderedDate to() {
        return to;
    }

    public List<InvoiceStatus> invoiceStatusList() {
        return invoiceStatusList;
    }

    public boolean containsInvoiced() {
        return invoiceStatusList.contains(InvoiceStatus.請求済);
    }

    public boolean containsUnInvoiced() {
        return invoiceStatusList.contains(InvoiceStatus.未請求);
    }
}
