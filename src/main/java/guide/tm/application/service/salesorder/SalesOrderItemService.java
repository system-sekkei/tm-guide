package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;
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
    public void register(SalesOrderNumber salesOrderNumber, SingleOrderItemContent singleOrderItemContent) {
        salesOrderItemRepository.registerBundleProductOrderItem(salesOrderNumber, singleOrderItemContent);
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
    public SingleProductOrderItems singleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderItemRepository.singleProductOrderItemsOf(salesOrderNumber);
    }

    /**
     * セット商品の受注明細を取得する
     */
    public BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderItemRepository.bundleProductOrderItemsOf(salesOrderNumber);
    }
}
