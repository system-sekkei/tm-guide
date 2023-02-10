package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderRepository;
import guide.tm.domain.model.customer.CustomerNumber;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.tax.context.TaxContext;
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
    public SalesOrderSummaries salesOrderSummaries() {
        return new SalesOrderSummaries(salesOrderMapper.salesOrderSummaries());
    }

    @Override
    public TaxContext taxContextOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderMapper.taxContextOf(salesOrderNumber);
    }

    @Override
    public void registerTax(TaxContext taxContext, SalesOrderNumber salesOrderNumber) {
        salesOrderMapper.registerTax(taxContext, salesOrderNumber);
    }

    @Override
    public SalesOrderSummaries salesOrderSummariesOf(CustomerNumber customerNumber) {
        return new SalesOrderSummaries(salesOrderMapper.salesOrderSummariesOf(customerNumber));
    }
}
