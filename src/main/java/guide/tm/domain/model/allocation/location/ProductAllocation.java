package guide.tm.domain.model.allocation.location;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.primitive.Quantity;

/**
 * 商品の引当
 */
public class ProductAllocation {
    ProductCode productCode;
    AllocatedLocations allocatedLocations;

    public ProductAllocation() {
        this(new ProductCode(), new AllocatedLocations());
    }

    public ProductAllocation(ProductCode productCode, AllocatedLocations allocatedLocations) {
        this.productCode = productCode;
        this.allocatedLocations = allocatedLocations;
    }

    public Quantity allocatedQuantity() {
        return allocatedLocations.allocatedQuantity();
    }

    public boolean isAllocated(Quantity quantity) {
        return allocatedQuantity().isEqual(quantity);
    }
}
