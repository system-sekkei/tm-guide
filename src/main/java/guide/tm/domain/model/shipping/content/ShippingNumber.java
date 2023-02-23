package guide.tm.domain.model.shipping.content;

/**
 * 出荷番号
 */
public class ShippingNumber {
    String value;

    ShippingNumber() {
        this("");
    }

    public ShippingNumber(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
