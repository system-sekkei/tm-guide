package guide.tm.domain.model.allocation.summary;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderSummary;

/**
 * 引当サマリー
 */
public class AllocationSummary {
    SalesOrderSummary salesOrderSummary;
    AllocatedStatus allocatedStatus;

    public SalesOrderSummary salesOrderSummary() {
        return salesOrderSummary;
    }

    public AllocatedStatus allocatedStatus() {
        return allocatedStatus;
    }

    public SalesOrderId salesOrderId() {
        return salesOrderSummary.salesOrderId();
    }
}
