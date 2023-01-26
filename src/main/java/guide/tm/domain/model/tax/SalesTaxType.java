package guide.tm.domain.model.tax;

/**
 * 消費税計算種別
 */
public enum SalesTaxType {
    総額計算,
    積上計算,
    ;

    public boolean is総額計算() {
        return this == 総額計算;
    }

    public boolean is積上計算() {
        return this == 積上計算;
    }
}
