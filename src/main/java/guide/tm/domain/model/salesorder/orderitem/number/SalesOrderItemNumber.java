package guide.tm.domain.model.salesorder.orderitem.number;

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
