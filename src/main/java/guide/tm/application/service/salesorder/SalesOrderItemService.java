package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.SalesOrderItem;
import guide.tm.domain.model.salesorder.SalesOrderItems;
import guide.tm.domain.model.salesorder.SalesOrderNumber;
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
    public void register(SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem) {
        salesOrderItemRepository.register(salesOrderNumber, salesOrderItem);
    }

    /**
     * 受注明細を取得する
     */
    public SalesOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderItemRepository.salesOrderItemsOf(salesOrderNumber);
    }
}
