package guide.tm.domain.primitive.contact;

/**
 * 電話番号
 */
public class PhoneNumber {
    String value;

    public PhoneNumber() {
        this("");
    }

    public PhoneNumber(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
