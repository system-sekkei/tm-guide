package guide.tm.domain.model.allocation.allocation;

import java.util.List;

public class Allocations {
    List<Allocation> list;

    public Allocations(List<Allocation> list) {
        this.list = list;
    }

    public List<Allocation> list() {
        return list;
    }
}
