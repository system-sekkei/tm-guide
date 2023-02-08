package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import org.springframework.stereotype.Service;

/**
 * 受注明細サービス
 */
@Service
public class SalesOrderItemService {

    SalesOrderItemRepository salesOrderItemRepository;

    SalesOrderItemService(SalesOrderItemRepository salesOrderItemRepository) {
        this.salesOrderItemRepository = salesOrderItemRepository;
    }

    /**
     * 受注明細を登録する
     */
    public void register(SalesOrderNumber salesOrderNumber, SalesOrderItemContent salesOrderItemContent) {
        salesOrderItemRepository.registerBundleProductOrderItem(salesOrderNumber, salesOrderItemContent);
    }

    /**
     * セット商品の受注明細を登録する
     */
    public void registerBundleProductOrderItem(SalesOrderNumber salesOrderNumber, BundleProductOrderItemContent bundleProductOrderItemContent) {
        salesOrderItemRepository.registerBundleProductOrderItem(salesOrderNumber, bundleProductOrderItemContent);
    }

    /**
     * 受注明細を取得する
     */
    public SalesOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderItemRepository.salesOrderItemsOf(salesOrderNumber);
    }

    /**
     * セット商品の受注明細を取得する
     */
    public BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderItemRepository.bundleProductOrderItemsOf(salesOrderNumber);
    }
}
