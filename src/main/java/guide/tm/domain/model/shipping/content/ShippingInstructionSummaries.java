package guide.tm.domain.model.shipping.content;

import java.util.List;

/**
 * 出荷指示のリスト
 */
public class ShippingInstructionSummaries {
    List<ShippingInstructionSummary> list;

    public ShippingInstructionSummaries(List<ShippingInstructionSummary> list) {
        this.list = list;
    }

    public List<ShippingInstructionSummary> list() {
        return list;
    }
}
