package guide.tm.domain.model.salesorder.order;

/**
 * 受注番号
 */
public class SalesOrderNumber {
    String value;

    public SalesOrderNumber() {
        this("");
    }

    public SalesOrderNumber(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isSame(SalesOrderNumber other) {
        return value.equals(other.value);
    }
}
