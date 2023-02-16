package guide.tm.domain.model.allocation.single;

import guide.tm.domain.model.allocation.location.ProductAllocation;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import guide.tm.domain.primitive.Quantity;

/**
 * 引当
 */
public class SingleAllocation {
    SingleAllocationNumber singleAllocationNumber;
    SalesOrderNumber salesOrderNumber;
    SalesOrderItemNumber salesOrderItemNumber;
    ProductAllocation productAllocation;

    public SingleAllocation() {
        this(new SingleAllocationNumber(), new SalesOrderNumber(), new SalesOrderItemNumber(), new ProductAllocation());
    }

    public SingleAllocation(
            SingleAllocationNumber singleAllocationNumber,
            SalesOrderNumber salesOrderNumber,
            SalesOrderItemNumber salesOrderItemNumber,
            ProductAllocation productAllocation) {
        this.singleAllocationNumber = singleAllocationNumber;
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.productAllocation = productAllocation;
    }

    public Quantity allocatedQuantity() {
        return productAllocation.allocatedQuantity();
    }
}
