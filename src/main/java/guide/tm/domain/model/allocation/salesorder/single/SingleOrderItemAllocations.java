package guide.tm.domain.model.allocation.salesorder.single;

import java.util.List;

public class SingleOrderItemAllocations {
    List<SingleOrderItemAllocation> list;

    public SingleOrderItemAllocations(List<SingleOrderItemAllocation> list) {
        this.list = list;
    }

    public List<SingleOrderItemAllocation> list() {
        return list;
    }
}
