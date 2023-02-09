package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.primitive.Quantity;

import java.util.ArrayList;
import java.util.List;

public class AllocationContents {
    List<AllocationContent> list;

    AllocationContents() {
        this(new ArrayList<>());
    }


    public AllocationContents(List<AllocationContent> list) {
        this.list = list;
    }

    public List<AllocationContent> list() {
        return list;
    }

    public Quantity allocatedQuantity() {
        return list.stream()
                .map(AllocationContent::allocatedQuantity)
                .reduce(Quantity::add)
                .orElse(new Quantity(0));
    }
}
