package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderRepository;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSearchCriteria;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
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
    public SalesOrderNumber registerSalesOrder(SalesOrderContent salesOrder) {
        UUID salesOrderNumber = UUID.randomUUID();
        salesOrderMapper.registerSalesOrder(salesOrderNumber, salesOrder);
        return new SalesOrderNumber(salesOrderNumber.toString());
    }

    @Override
    public SalesOrderContent salesOrderOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderMapper.salesOrderOf(salesOrderNumber);
    }

    @Override
    public SalesOrderSummaries salesOrderSummaries(SalesOrderSearchCriteria salesOrderSearchCriteria) {
        return new SalesOrderSummaries(salesOrderMapper.salesOrderSummaries(salesOrderSearchCriteria));
    }

    @Override
    public TaxSumType taxSumTypeOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderMapper.taxSumTypeOf(salesOrderNumber);
    }

    @Override
    public void registerTax(TaxSumType taxSumType, SalesOrderNumber salesOrderNumber) {
        salesOrderMapper.registerTax(taxSumType, salesOrderNumber);
    }

}
