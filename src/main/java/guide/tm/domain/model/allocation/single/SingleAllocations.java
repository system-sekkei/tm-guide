package guide.tm.domain.model.allocation.single;

import java.util.List;

/**
 * 個別商品の引当のリスト
 */
public class SingleAllocations {
    List<SingleAllocation> list;

    public SingleAllocations(List<SingleAllocation> list) {
        this.list = list;
    }
}
