package guide.tm.application.service.salesorder;

import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.OrderedYearMonth;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.*;
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
    public SalesOrderId registerSalesOrder(SalesOrderContent salesOrder) {
        return salesOrderRepository.registerSalesOrder(salesOrder);
    }

    /**
     * 受注を取得する
     */
    public SalesOrderContent salesOrderOf(SalesOrderId salesOrderId) {
        return salesOrderRepository.salesOrderOf(salesOrderId);
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
    public TaxSumType taxSumTypeOf(SalesOrderId salesOrderId) {
        return salesOrderRepository.taxSumTypeOf(salesOrderId);
    }

    /**
     * 消費税を登録する
     */
    public void registerTax(TaxSumType taxSumType, SalesOrderId salesOrderId) {
        salesOrderRepository.registerTax(taxSumType, salesOrderId);
    }

    /**
     * 受注IDのリストを取得
     *
     * 顧客、受注年月の指定で、受注IDのリストを取得する
     */
    public SalesOrderIdList salesOrderIdsOf(CustomerId customerId, OrderedYearMonth orderedYearMonth) {
        return salesOrderRepository.salesOrderIdsOf(customerId, orderedYearMonth);
    }

    /**
     * 受注完了を記録する
     */
    public void markAsOrdered(SalesOrderId salesOrderId) {
        salesOrderRepository.markAsOrdered(salesOrderId);
    }

    /**
     * 受注完了区分を取得する
     */
    public SalesOrderedType orderedStatusOf(SalesOrderId salesOrderId) {
        return salesOrderRepository.orderedStatusOf(salesOrderId);
    }
}
