package guide.tm.domain.model.allocation.warehouse;

/**
 * 倉庫コード
 */
public class WareHouseCode {
    String value;

    public WareHouseCode() {
        this("");
    }

    public WareHouseCode(String value) {
        this.value = value;
    }

    public boolean isSame(WareHouseCode other) {
        return value.equals(other.value);
    }
}
