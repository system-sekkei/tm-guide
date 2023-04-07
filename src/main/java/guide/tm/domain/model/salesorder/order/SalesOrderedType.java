package guide.tm.domain.model.salesorder.order;

public enum SalesOrderedType {
    受注完了,
    受注未完了,
    ;

    public boolean isCompleted() {
        return this == 受注完了;
    }
}
