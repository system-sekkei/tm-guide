package guide.tm.domain.model.allocation.warehouse;

/**
 * 倉庫
 */
public class WareHouse {
    WareHouseCode wareHouseCode;
    String name;
    String address;

    public WareHouse(WareHouseCode wareHouseCode, String name, String address) {
        this.wareHouseCode = wareHouseCode;
        this.name = name;
        this.address = address;
    }

    public WareHouseCode wareHouseCode() {
        return wareHouseCode;
    }
}
