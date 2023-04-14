package guide.tm.domain.model.customer;

/**
 * 顧客名称
 */
public class Name {
    String value;

    Name() {
        this("");
    }

    public Name(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
