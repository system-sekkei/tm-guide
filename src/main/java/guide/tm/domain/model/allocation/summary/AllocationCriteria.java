package guide.tm.domain.model.allocation.summary;

import guide.tm.domain.model.salesorder.content.OrderedDate;

import java.util.Arrays;
import java.util.List;

public class AllocationCriteria {

    OrderedDate from;
    OrderedDate to;

    List<AllocatedStatus> allocationStatusList;

    public AllocationCriteria() {
        this.from = new OrderedDate();
        this.to = new OrderedDate();
        this.allocationStatusList = Arrays.asList(AllocatedStatus.引当済, AllocatedStatus.引当残あり);
    }

    public OrderedDate from() {
        return from;
    }

    public OrderedDate to() {
        return to;
    }

    public List<AllocatedStatus> allocationStatusList() {
        return allocationStatusList;
    }

    public boolean containsAllocated() {
        return allocationStatusList.contains(AllocatedStatus.引当済);
    }

    public boolean containsNotAllocated() {
        return allocationStatusList.contains(AllocatedStatus.引当残あり);
    }
}
