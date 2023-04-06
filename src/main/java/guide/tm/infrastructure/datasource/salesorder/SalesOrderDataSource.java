package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderRepository;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.OrderedYearMonth;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.*;
import guide.tm.domain.model.tax.context.TaxSumType;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SalesOrderDataSource implements SalesOrderRepository {

    SalesOrderMapper salesOrderMapper;

    SalesOrderDataSource(SalesOrderMapper salesOrderMapper) {
        this.salesOrderMapper = salesOrderMapper;
    }

    @Override
    public SalesOrderId registerSalesOrder(SalesOrderContent salesOrder) {
        UUID salesOrderId = UUID.randomUUID();
        SalesOrderNumber salesOrderNumber = new SalesOrderNumber(String.valueOf(salesOrderMapper.newSaleOrderNumber()));
        salesOrderMapper.registerSalesOrder(salesOrderId, salesOrderNumber, salesOrder);
        return new SalesOrderId(salesOrderId.toString());
    }

    @Override
    public SalesOrderContent salesOrderOf(SalesOrderId salesOrderId) {
        return salesOrderMapper.salesOrderOf(salesOrderId);
    }

    @Override
    public SalesOrderSummaries salesOrderSummaries(SalesOrderSearchCriteria salesOrderSearchCriteria) {
        return new SalesOrderSummaries(salesOrderMapper.salesOrderSummaries(salesOrderSearchCriteria));
    }

    @Override
    public TaxSumType taxSumTypeOf(SalesOrderId salesOrderId) {
        return salesOrderMapper.taxSumTypeOf(salesOrderId);
    }

    @Override
    public SalesOrderIdList salesOrderIdsOf(CustomerId customerId, OrderedYearMonth orderedYearMonth) {
        return new SalesOrderIdList(salesOrderMapper.salesOrderIdsOf(customerId, orderedYearMonth.startOfOrderedYearMonth(), orderedYearMonth.endOfOrderedYearMonth()));
    }

    @Override
    public void registerTax(TaxSumType taxSumType, SalesOrderId salesOrderId) {
        salesOrderMapper.registerTax(taxSumType, salesOrderId);
    }

}
