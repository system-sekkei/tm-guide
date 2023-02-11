package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.detail.ProductCode;

import java.util.List;

public class AllocationContent {
    ProductCode productCode;
    AllocatedLocations allocatedLocations;


    public AllocationContent() {
        this(new ProductCode(), new AllocatedLocations());
    }

    public AllocationContent(ProductCode productCode, AllocatedLocations allocatedLocations) {
        this.productCode = productCode;
        this.allocatedLocations = allocatedLocations;
    }

    public List<AllocatedLocation> list() {
        return allocatedLocations.list;
    }

    public Quantity allocatedQuantity() {
        return allocatedLocations.allocatedQuantity();
    }

    boolean isAllocated(Quantity orderedQuantity) {
        return allocatedLocations.allocatedQuantity().isEqual(orderedQuantity);
    }
}
