package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.primitive.Quantity;

import java.util.List;

public class AllocationContents {
    List<AllocationContent> list;

    @Deprecated AllocationContents() {
    }

    public AllocationContents(List<AllocationContent> list) {
        this.list = list;
    }

    public List<AllocationContent> list() {
        return list;
    }

    public boolean isAllAllocated(Quantity quantity) {
        return list.stream().allMatch(allocationContent -> allocationContent.isAllocated(quantity));
    }

    public Quantity allocatedQuantity() {
        return list.stream().map(AllocationContent::allocatedQuantity)
                .min(Quantity::compare)
                .orElse(new Quantity());
    }
}
