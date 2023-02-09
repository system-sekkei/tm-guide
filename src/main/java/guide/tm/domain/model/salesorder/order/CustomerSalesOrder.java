package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.customer.Customer;

public class CustomerSalesOrder {
    Customer customer;
    SalesOrderSummaries salesOrderSummaries;

    public CustomerSalesOrder(Customer customer, SalesOrderSummaries salesOrderSummaries) {
        this.customer = customer;
        this.salesOrderSummaries = salesOrderSummaries;
    }

    public Customer customer() {
        return customer;
    }

    public SalesOrderSummaries salesOrderSummaries() {
        return salesOrderSummaries;
    }
}
