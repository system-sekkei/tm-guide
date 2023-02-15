package guide.tm.domain.model.allocation.single;

import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;

import java.util.List;

/**
 * 個別商品の引当のリスト
 */
public class SingleAllocations {
    List<SingleAllocation> list;

    public SingleAllocations(List<SingleAllocation> list) {
        this.list = list;
    }

    public SingleAllocation allocationOf(SingleOrderItem salesOrderItem) {
        return list.stream()
                .filter(allocation -> allocation.salesOrderItemNumber.isSame(salesOrderItem.salesOrderItemNumber()))
                .findFirst()
                .orElse(new SingleAllocation());
    }
}
