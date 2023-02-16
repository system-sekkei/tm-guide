package guide.tm.domain.model.allocation.status.single;

import guide.tm.domain.model.allocation.single.SingleAllocations;

import java.util.List;

/**
 * 個別商品の受注明細と引当のリスト
 */
public class SingleOrderItemStatusList {
    List<SingleOrderItemStatus> list;

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
     * 未出荷の個別商品の引当のリスト
     */
    public SingleAllocations notShippedItemAllocations() {
        return new SingleAllocations(
                list.stream()
                        .filter(it -> !it.isShippingInstructed())
                        .map(SingleOrderItemStatus::singleAllocation)
                        .toList());
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
