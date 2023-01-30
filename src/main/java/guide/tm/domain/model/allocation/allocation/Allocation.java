package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.model.primitive.Quantity;

/**
 * 引当
 */
public class Allocation {
    WareHouseCode wareHouseCode;
    Quantity allocatedQuantity;

    public Allocation(WareHouseCode wareHouseCode, Quantity allocatedQuantity) {
        this.wareHouseCode = wareHouseCode;
        this.allocatedQuantity = allocatedQuantity;
    }
}
