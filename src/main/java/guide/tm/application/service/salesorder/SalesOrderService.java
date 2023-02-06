package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.tax.context.TaxContext;
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
    public SalesOrderNumber registerSalesOrder(SalesOrderContent salesOrder) {
        return salesORderRepository.registerSalesOrder(salesOrder);
    }

    /**
     * 受注を取得する
     */
    public SalesOrderContent salesOrderOf(SalesOrderNumber salesOrderNumber) {
        return salesORderRepository.salesOrderOf(salesOrderNumber);
    }


    /**
     * 受注の一覧を取得する
     */
    public SalesOrderSummaries salesOrderSummaries() {
        return salesORderRepository.salesOrderSummaries();
    }

    /**
     * 受注時の消費税を取得する
     */
    public TaxContext taxContextOf(SalesOrderNumber salesOrderNumber) {
        return salesORderRepository.taxContextOf(salesOrderNumber);
    }
}
