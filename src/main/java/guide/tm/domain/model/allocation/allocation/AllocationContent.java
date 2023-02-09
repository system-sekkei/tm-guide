package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.model.primitive.Quantity;

/**
 * 引当内容
 */
public class AllocationContent {

    WareHouseCode wareHouseCode;
    Quantity allocatedQuantity;

    @Deprecated AllocationContent() {
    }

    public AllocationContent(
            WareHouseCode wareHouseCode,
            Quantity allocatedQuantity) {
        this.wareHouseCode = wareHouseCode;
        this.allocatedQuantity = allocatedQuantity;
    }
}
