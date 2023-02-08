package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.application.service.salesorder.SalesOrderItemRepository;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SalesOrderItemDataSource implements SalesOrderItemRepository {

    SalesOrderItemMapper salesOrderItemMapper;

    SalesOrderItemDataSource(SalesOrderItemMapper salesOrderItemMapper) {
        this.salesOrderItemMapper = salesOrderItemMapper;
    }

    @Override
    public void registerBundleProductOrderItem(SalesOrderNumber salesOrderNumber, SalesOrderItemContent salesOrderItemContent) {
        UUID saleOrderItemNumber = UUID.randomUUID();
        salesOrderItemMapper.register(salesOrderNumber, saleOrderItemNumber, salesOrderItemContent);
    }

    @Override
    public SalesOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return new SalesOrderItems(salesOrderItemMapper.salesOrderItemsOf(salesOrderNumber));
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
