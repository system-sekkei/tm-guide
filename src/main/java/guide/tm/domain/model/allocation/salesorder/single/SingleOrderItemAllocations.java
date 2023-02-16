package guide.tm.domain.model.allocation.salesorder.single;

import java.util.ArrayList;
import java.util.List;

/**
 * 個別商品の受注明細と引当のリスト
 */
public class SingleOrderItemAllocations {
    List<SingleOrderItemAllocation> list;

    public SingleOrderItemAllocations() {
        this(new ArrayList<>());
    }

    public SingleOrderItemAllocations(List<SingleOrderItemAllocation> list) {
        this.list = list;
    }

    public List<SingleOrderItemAllocation> list() {
        return list;
    }

    /**
     * 引当済の個別商品の受注明細と引当のリスト
     */
    public SingleOrderItemAllocations allocated() {
        return new SingleOrderItemAllocations(
                list.stream()
                        .filter(SingleOrderItemAllocation::isAllAllocated)
                        .toList());
    }

    /**
     * 未出荷の個別商品の受注明細と引当のリスト
     */
    public SingleOrderItemAllocations notShippedItemAllocations(SingleOrderItemAllocations shippedSalesOrderItems) {
        return new SingleOrderItemAllocations(
                list.stream().filter(it -> !shippedSalesOrderItems.contains(it))
                        .toList());
    }

    private boolean contains(SingleOrderItemAllocation singleOrderItemAllocation) {
        return list.stream()
                .anyMatch(it -> it.singleOrderItem.isSame(singleOrderItemAllocation.singleOrderItem()));
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
