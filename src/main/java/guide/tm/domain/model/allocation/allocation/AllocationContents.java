package guide.tm.domain.model.allocation.allocation;

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
}
