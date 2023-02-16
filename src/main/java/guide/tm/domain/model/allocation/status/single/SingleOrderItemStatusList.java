package guide.tm.domain.model.allocation.status.single;

import java.util.ArrayList;
import java.util.List;

/**
 * 個別商品の受注明細と引当のリスト
 */
public class SingleOrderItemStatusList {
    List<SingleOrderItemStatus> list;

    public SingleOrderItemStatusList() {
        this(new ArrayList<>());
    }

    public SingleOrderItemStatusList(List<SingleOrderItemStatus> list) {
        this.list = list;
    }

    public List<SingleOrderItemStatus> list() {
        return list;
    }

    /**
     * 引当済の個別商品の受注明細と引当のリスト
     */
    public SingleOrderItemStatusList allocated() {
        return new SingleOrderItemStatusList(
                list.stream()
                        .filter(SingleOrderItemStatus::isAllAllocated)
                        .toList());
    }

    /**
     * 未出荷の個別商品の受注明細と引当のリスト
     */
    public SingleOrderItemStatusList notShippedItemAllocations(SingleOrderItemStatusList shippedSalesOrderItems) {
        return new SingleOrderItemStatusList(
                list.stream().filter(it -> !shippedSalesOrderItems.contains(it))
                        .toList());
    }

    private boolean contains(SingleOrderItemStatus singleOrderItemStatus) {
        return list.stream()
                .anyMatch(it -> it.singleOrderItem.isSame(singleOrderItemStatus.singleOrderItem()));
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
