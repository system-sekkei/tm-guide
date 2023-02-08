package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
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
        salesOrderItemRepository.register(salesOrderNumber, salesOrderItemContent);
    }

    /**
     * 受注明細を取得する
     */
    public SalesOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderItemRepository.salesOrderItemsOf(salesOrderNumber);
    }
}
