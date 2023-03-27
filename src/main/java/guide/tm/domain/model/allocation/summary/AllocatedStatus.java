package guide.tm.domain.model.allocation.summary;

public enum AllocatedStatus {
    引当残あり,
    引当済,
    ;

    public boolean isAllocated() {
        return this == 引当済;
    }
}
