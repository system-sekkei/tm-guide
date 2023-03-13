package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSearchCriteria;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.tax.context.TaxSumType;
import org.springframework.stereotype.Service;

/**
 * 受注サービス
 */
@Service
public class SalesOrderService {
    SalesOrderRepository salesOrderRepository;

    SalesOrderService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    /**
     * 受注を登録する
     */
    public SalesOrderNumber registerSalesOrder(SalesOrderContent salesOrder) {
        return salesOrderRepository.registerSalesOrder(salesOrder);
    }

    /**
     * 受注を取得する
     */
    public SalesOrderContent salesOrderOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderRepository.salesOrderOf(salesOrderNumber);
    }


    /**
     * 受注の一覧を取得する
     */
    public SalesOrderSummaries salesOrderSummaries(SalesOrderSearchCriteria salesOrderSearchCriteria) {
        return salesOrderRepository.salesOrderSummaries(salesOrderSearchCriteria);
    }

    /**
     * 受注時の消費税を取得する
     */
    public TaxSumType taxSumTypeOf(SalesOrderNumber salesOrderNumber) {
        return salesOrderRepository.taxSumTypeOf(salesOrderNumber);
    }

    /**
     * 消費税を登録する
     */
    public void registerTax(TaxSumType taxSumType, SalesOrderNumber salesOrderNumber) {
        salesOrderRepository.registerTax(taxSumType, salesOrderNumber);
    }
}
