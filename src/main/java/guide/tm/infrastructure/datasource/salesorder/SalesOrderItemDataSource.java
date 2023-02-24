package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderItemRepository;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItemContent;
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
    public void registerBundleProductOrderItem(SalesOrderNumber salesOrderNumber, SingleOrderItemContent singleOrderItemContent) {
        UUID saleOrderItemNumber = UUID.randomUUID();
        salesOrderItemMapper.register(salesOrderNumber, saleOrderItemNumber, singleOrderItemContent);
    }

    @Override
    public SingleProductOrderItems singleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return new SingleProductOrderItems(salesOrderItemMapper.salesOrderItemsOf(salesOrderNumber));
    }

    @Override
    public void registerBundleProductOrderItem(
            SalesOrderNumber salesOrderNumber, BundleProductOrderItemContent bundleProductOrderItemContent) {
        UUID saleOrderItemNumber = UUID.randomUUID();
        salesOrderItemMapper.registerBundleProductOrderItem(salesOrderNumber, saleOrderItemNumber, bundleProductOrderItemContent);

    }

    @Override
    public BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return new BundleProductOrderItems(salesOrderItemMapper.bundleProductOrderItemsOf(salesOrderNumber));
    }
}
