package guide.tm.domain.model.allocation.summary;

import java.util.ArrayList;
import java.util.List;

public class AllocationSummaries {
    List<AllocationSummary> list;

    public AllocationSummaries(List<AllocationSummary> allocated, List<AllocationSummary> notAllocated) {
        list = new ArrayList<>();
        list.addAll(allocated);
        list.addAll(notAllocated);
        list.sort((a1, a2) -> a1.salesOrderSummary.salesOrderNumber().compareTo(a2.salesOrderSummary.salesOrderNumber()));
    }

    public List<AllocationSummary> list() {
        return list;
    }
}
