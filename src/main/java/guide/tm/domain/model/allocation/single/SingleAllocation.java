package guide.tm.domain.model.allocation.single;

import guide.tm.domain.model.allocation.location.ProductAllocation;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;

/**
 * 引当
 */
public class SingleAllocation {
    SingleAllocationNumber singleAllocationNumber;
    SalesOrderNumber salesOrderNumber;
    SalesOrderItemNumber salesOrderItemNumber;
    ProductAllocation productAllocation;

    public Quantity allocatedQuantity() {
        return productAllocation.allocatedQuantity();
    }
}
