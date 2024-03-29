package guide.tm.application.service.salesorder;

import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.OrderedYearMonth;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.*;
import guide.tm.domain.model.tax.context.TaxSumType;

public interface SalesOrderRepository {
    SalesOrderId registerSalesOrder(SalesOrderContent salesOrder);

    SalesOrderContent salesOrderOf(SalesOrderId salesOrderId);

    SalesOrderSummaries salesOrderSummaries(SalesOrderSearchCriteria salesOrderSearchCriteria);

    void registerTax(TaxSumType taxSumType, SalesOrderId salesOrderId);

    TaxSumType taxSumTypeOf(SalesOrderId salesOrderId);

    SalesOrderIdList salesOrderIdsOf(CustomerId customerId, OrderedYearMonth orderedYearMonth);

    void markAsOrdered(SalesOrderId salesOrderId);

    SalesOrderedType orderedStatusOf(SalesOrderId salesOrderId);
}
