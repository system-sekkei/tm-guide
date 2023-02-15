package guide.tm.domain.model.allocation.location;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.primitive.Quantity;

public class ProductAllocation {
    ProductCode productCode;
    AllocatedLocations allocatedLocations;

    public Quantity allocatedQuantity() {
        return allocatedLocations.allocatedQuantity();
    }

    public boolean isAllocated(Quantity quantity) {
        return allocatedQuantity().isEqual(quantity);
    }
}
