package guide.tm.domain.model.allocation.location;


import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.primitive.Quantity;

/**
 * 引当場所
 */
public class AllocatedLocation {

    WareHouseCode wareHouseCode;
    Quantity allocatedQuantity;

    @Deprecated
    AllocatedLocation() {
    }

    public AllocatedLocation(WareHouseCode wareHouseCode, Quantity allocatedQuantity) {
        this.wareHouseCode = wareHouseCode;
        this.allocatedQuantity = allocatedQuantity;
    }

    public Quantity allocatedQuantity() {
        return allocatedQuantity;
    }

    public WareHouseCode wareHouseCode() {
        return wareHouseCode;
    }
}