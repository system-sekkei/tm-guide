package guide.tm.domain.model.salesorder.order;

/**
 * 受注番号
 */
public class SalesOrderNumber {
    String value;

    @Deprecated SalesOrderNumber() {
        this("");
    }

    public SalesOrderNumber(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
