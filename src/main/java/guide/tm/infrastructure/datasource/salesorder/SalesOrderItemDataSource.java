package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderItemRepository;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SalesOrderItemDataSource implements SalesOrderItemRepository {

    SalesOrderItemMapper salesOrderItemMapper;

    SalesOrderItemDataSource(SalesOrderItemMapper salesOrderItemMapper) {
        this.salesOrderItemMapper = salesOrderItemMapper;
    }

    @Override
    public SingleProductOrderItems singleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return new SingleProductOrderItems(salesOrderItemMapper.salesOrderItemsOf(salesOrderNumber));
    }

    @Override
    public BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return new BundleProductOrderItems(salesOrderItemMapper.bundleProductOrderItemsOf(salesOrderNumber));
    }

    @Override
    public void registerSingleProductOrder(SalesOrderNumber salesOrderNumber, SalesOrderItemRequest salesOrderItemRequest) {
        UUID saleOrderItemNumber = UUID.randomUUID();
        salesOrderItemMapper.registerSingleProductOrder(salesOrderNumber, saleOrderItemNumber, salesOrderItemRequest);
    }

    @Override
    public void registerBundleProductOrder(SalesOrderNumber salesOrderNumber, SalesOrderItemRequest salesOrderItemRequest) {
        UUID saleOrderItemNumber = UUID.randomUUID();
        salesOrderItemMapper.registerBundleProductOrder(salesOrderNumber, saleOrderItemNumber, salesOrderItemRequest);
    }
}
