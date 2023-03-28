package guide.tm.domain.model.allocation.summary;

import java.util.List;

public class AllocationSummaries {
    List<AllocationSummary> list;

    public AllocationSummaries(List<AllocationSummary> list) {
        this.list = list;
        list.sort((a1, a2) -> a1.salesOrderSummary.salesOrderNumber().compareTo(a2.salesOrderSummary.salesOrderNumber()));
    }

    public List<AllocationSummary> list() {
        return list;
    }
}
