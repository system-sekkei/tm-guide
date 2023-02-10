package guide.tm.domain.model.allocation.allocation;

import java.util.List;

public class SalesOrderAllocations {
    List<SalesOrderAllocation> list;

    public SalesOrderAllocations(List<SalesOrderAllocation> list) {
        this.list = list;
    }

    public List<SalesOrderAllocation> list() {
        return list;
    }

}
