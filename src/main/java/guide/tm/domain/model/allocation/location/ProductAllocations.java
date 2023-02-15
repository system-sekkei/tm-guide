package guide.tm.domain.model.allocation.location;

import guide.tm.domain.model.primitive.Quantity;

import java.util.List;

public class ProductAllocations {
    List<ProductAllocation> list;

    public boolean isAllAllocated(Quantity quantity) {
        return list.stream().allMatch(productAllocation -> productAllocation.isAllocated(quantity));
    }

    public Quantity allocatedQuantity() {
        return list.stream().map(ProductAllocation::allocatedQuantity)
                .min(Quantity::compare)
                .orElse(new Quantity());
    }
}
