package guide.tm.domain.model.allocation.location;

import guide.tm.domain.primitive.Quantity;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品の引当リスト
 */
public class ProductAllocations {
    List<ProductAllocation> list;

    public ProductAllocations() {
        this(new ArrayList<>());
    }

    public ProductAllocations(List<ProductAllocation> list) {
        this.list = list;
    }

    public boolean isAllAllocated(Quantity quantity) {
        if (list.isEmpty()) return false;
        return list.stream().allMatch(productAllocation -> productAllocation.isAllocated(quantity));
    }

    public Quantity allocatedQuantity() {
        return list.stream().map(ProductAllocation::allocatedQuantity)
                .min(Quantity::compare)
                .orElse(new Quantity());
    }
}
