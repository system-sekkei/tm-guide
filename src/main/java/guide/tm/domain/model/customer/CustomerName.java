package guide.tm.domain.model.customer;

/**
 * 顧客名称
 */
public class CustomerName {
    String value;

    CustomerName() {
        this("");
    }

    public CustomerName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
