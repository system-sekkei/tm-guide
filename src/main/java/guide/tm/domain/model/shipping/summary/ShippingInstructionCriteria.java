package guide.tm.domain.model.shipping.summary;

import guide.tm.domain.model.salesorder.content.OrderedDate;

import java.util.Arrays;
import java.util.List;

/**
 * 出荷状況検索条件
 */
public class ShippingInstructionCriteria {
    OrderedDate from;
    OrderedDate to;

    List<ShippingInstructionStatus> shippingInstructionStatusList;

    public ShippingInstructionCriteria() {
        this.from = new OrderedDate();
        this.to = new OrderedDate();
        this.shippingInstructionStatusList = Arrays.asList(ShippingInstructionStatus.出荷指示済, ShippingInstructionStatus.出荷指示残あり);
    }

    public OrderedDate from() {
        return from;
    }

    public OrderedDate to() {
        return to;
    }

    public List<ShippingInstructionStatus> shippingInstructionStatusList() {
        return shippingInstructionStatusList;
    }

    public boolean containsInstructed() {
        return shippingInstructionStatusList.contains(ShippingInstructionStatus.出荷指示済);
    }

    public boolean containsNotInstructed() {
        return shippingInstructionStatusList.contains(ShippingInstructionStatus.出荷指示残あり);
    }
}
