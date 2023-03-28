package guide.tm.domain.model.allocation.summary;

import guide.tm.domain.model.salesorder.content.OrderedDate;

public class AllocationCriteria {

    OrderedDate from;
    OrderedDate to;


    public AllocationCriteria() {
        this.from = new OrderedDate();
        this.to = new OrderedDate();
    }

    public OrderedDate from() {
        return from;
    }

    public OrderedDate to() {
        return to;
    }
}
