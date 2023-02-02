package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import org.springframework.stereotype.Service;

/**
 * 受注サービス
 */
@Service
public class SalesOrderService {
    SalesOrderRepository salesORderRepository;

    SalesOrderService(SalesOrderRepository salesOrderRepository) {
        this.salesORderRepository = salesOrderRepository;
    }

    /**
     * 受注を登録する
     */
    public SalesOrderNumber registerSalesOrder(SalesOrder salesOrder) {
        return salesORderRepository.registerSalesOrder(salesOrder);
    }

    /**
     * 受注を取得する
     */
    public SalesOrder salesOrderOf(SalesOrderNumber salesOrderNumber) {
        return salesORderRepository.salesOrderOf(salesOrderNumber);
    }


    /**
     * 受注の一覧を取得する
     */
    public SalesOrderSummaries salesOrderSummaries() {
        return salesORderRepository.salesOrderSummaries();
    }
}
