package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
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
     * 個別商品の受注明細を取得する
     */
    public SingleProductOrderItems singleProductOrderItemsOf(SalesOrderId salesOrderId) {
        return salesOrderItemRepository.singleProductOrderItemsOf(salesOrderId);
    }

    /**
     * セット商品の受注明細を取得する
     */
    public BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderId salesOrderId) {
        return salesOrderItemRepository.bundleProductOrderItemsOf(salesOrderId);
    }

    /**
     * 受注明細を登録する
     */
    public void register(SalesOrderId salesOrderId, SalesOrderItemRequest salesOrderItemRequest) {
        if (salesOrderItemRequest.isSingleProduct()) {
            salesOrderItemRepository.registerSingleProductOrder(salesOrderId, salesOrderItemRequest);
        } else {
            salesOrderItemRepository.registerBundleProductOrder(salesOrderId, salesOrderItemRequest);
        }
    }
}
