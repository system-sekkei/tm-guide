package guide.tm.domain.model.allocation.bundle;

import guide.tm.domain.model.allocation.location.ProductAllocations;
import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import guide.tm.domain.primitive.Quantity;

public class BundleAllocation {
    BundleAllocationNumber bundleAllocationNumber;
    SalesOrderNumber salesOrderNumber;
    SalesOrderItemNumber salesOrderItemNumber;
    ProductCode bundleProductCode;
    ProductAllocations productAllocations;

    BundleAllocation() {
        this(new BundleAllocationNumber(), new SalesOrderNumber(), new SalesOrderItemNumber(), new ProductCode(), new ProductAllocations());
    }

    public BundleAllocation(
            BundleAllocationNumber bundleAllocationNumber,
            SalesOrderNumber salesOrderNumber,
            SalesOrderItemNumber salesOrderItemNumber,
            ProductCode bundleProductCode,
            ProductAllocations productAllocations) {
        this.bundleAllocationNumber = bundleAllocationNumber;
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.bundleProductCode = bundleProductCode;
        this.productAllocations = productAllocations;
    }

    public boolean isAllocated(Quantity orderedQuantity) {
        return productAllocations.isAllAllocated(orderedQuantity);
    }

    public Quantity allocatedQuantity() {
        return productAllocations.allocatedQuantity();
    }

    boolean hasSameSalesOrderItemNumber(SalesOrderItemNumber other) {
        return salesOrderItemNumber.isSame(other);
    }


}
