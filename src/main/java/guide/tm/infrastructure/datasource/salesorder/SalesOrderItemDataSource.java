package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderItemRepository;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
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
    public SingleProductOrderItems singleProductOrderItemsOf(SalesOrderId salesOrderId) {
        return new SingleProductOrderItems(salesOrderItemMapper.salesOrderItemsOf(salesOrderId));
    }

    @Override
    public BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderId salesOrderId) {
        return new BundleProductOrderItems(salesOrderItemMapper.bundleProductOrderItemsOf(salesOrderId));
    }

    @Override
    public void registerSingleProductOrder(SalesOrderId salesOrderId, SalesOrderItemRequest salesOrderItemRequest) {
        UUID saleOrderItemNumber = UUID.randomUUID();
        salesOrderItemMapper.registerSingleProductOrder(salesOrderId, saleOrderItemNumber, salesOrderItemRequest);
        salesOrderItemMapper.registerActiveSingleProductOrder(salesOrderId, saleOrderItemNumber);
    }

    @Override
    public void registerBundleProductOrder(SalesOrderId salesOrderId, SalesOrderItemRequest salesOrderItemRequest) {
        UUID saleOrderItemNumber = UUID.randomUUID();
        salesOrderItemMapper.registerBundleProductOrder(salesOrderId, saleOrderItemNumber, salesOrderItemRequest);
        salesOrderItemMapper.registerActiveBundleProductOrder(salesOrderId, saleOrderItemNumber);
    }

    @Override
    public void deleteSingleOrderItem(SalesOrderId salesOrderId, SalesOrderItemNumber salesOrderItemNumber) {
        salesOrderItemMapper.deleteSingleOrderItem(salesOrderId, salesOrderItemNumber);
    }

    @Override
    public void deleteBundleOrderItem(SalesOrderId salesOrderId, SalesOrderItemNumber salesOrderItemNumber) {
        salesOrderItemMapper.deleteBundleOrderItem(salesOrderId, salesOrderItemNumber);
    }
}
