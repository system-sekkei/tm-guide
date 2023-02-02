package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderRepository;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SalesOrderDataSource implements SalesOrderRepository {

    SalesOrderMapper salesOrderMapper;

    SalesOrderDataSource(SalesOrderMapper salesOrderMapper) {
        this.salesOrderMapper = salesOrderMapper;
    }

    @Override
    public SalesOrderNumber registerSalesOrder(SalesOrder salesOrder) {
        UUID salesOrderNumber = UUID.randomUUID();
        salesOrderMapper.registerSalesOrder(salesOrderNumber, salesOrder);
        return new SalesOrderNumber(salesOrderNumber.toString());
    }

    @Override
    public SalesOrder salesOrderOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderMapper.salesOrderOf(salesOrderNumber);
    }

    @Override
    public SalesOrderSummaries salesOrderSummaries() {
        return new SalesOrderSummaries(salesOrderMapper.salesOrderSummaries());
    }


}
