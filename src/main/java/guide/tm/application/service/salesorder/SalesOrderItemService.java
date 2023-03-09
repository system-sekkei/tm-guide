package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
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
    public SingleProductOrderItems singleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderItemRepository.singleProductOrderItemsOf(salesOrderNumber);
    }

    /**
     * セット商品の受注明細を取得する
     */
    public BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderItemRepository.bundleProductOrderItemsOf(salesOrderNumber);
    }

    /**
     * 受注明細を登録する
     */
    public void register(SalesOrderNumber salesOrderNumber, SalesOrderItemRequest salesOrderItemRequest) {
        if (salesOrderItemRequest.isSingleProduct()) {
            salesOrderItemRepository.registerSingleProductOrder(salesOrderNumber, salesOrderItemRequest);
        } else {
            salesOrderItemRepository.registerBundleProductOrder(salesOrderNumber, salesOrderItemRequest);
        }
    }
}
