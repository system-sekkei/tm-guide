package guide.tm.domain.model.allocation.location;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.detail.ProductCode;

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
