package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderItemRepository;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SalesOrderItemDataSource implements SalesOrderItemRepository {

    SalesOrderItemMapper salesOrderItemMapper;

    SalesOrderItemDataSource(SalesOrderItemMapper salesOrderItemMapper) {
        this.salesOrderItemMapper = salesOrderItemMapper;
    }

    @Override
    public void register(SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem) {
        UUID saleOrderItemNumber = UUID.randomUUID();
        salesOrderItemMapper.register(salesOrderNumber, saleOrderItemNumber, salesOrderItem);
    }

    @Override
    public SalesOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return new SalesOrderItems(salesOrderItemMapper.salesOrderItemsOf(salesOrderNumber));
    }
}
