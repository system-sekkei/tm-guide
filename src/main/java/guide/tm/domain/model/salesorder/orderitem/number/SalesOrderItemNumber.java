package guide.tm.domain.model.salesorder.orderitem.number;

/**
 * 受注明細番号
 */
public class SalesOrderItemNumber {
    String value;

    public SalesOrderItemNumber() {
        this("");
    }

    public SalesOrderItemNumber(String value) {
        this.value = value;
    }

    public boolean isSame(SalesOrderItemNumber other) {
        return value.equals(other.value);
    }
}
