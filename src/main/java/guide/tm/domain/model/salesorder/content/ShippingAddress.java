package guide.tm.domain.model.salesorder.content;

/**
 * 届け先住所
 */
public class ShippingAddress {
    Prefecture prefecture;
    String addressLine;

    public ShippingAddress() {
        this(Prefecture.北海道, "");
    }

    public ShippingAddress(Prefecture prefecture, String addressLine) {
        this.prefecture = prefecture;
        this.addressLine = addressLine;
    }

    public Prefecture prefecture() {
        return prefecture;
    }

    public String addressLine() {
        return addressLine;
    }

    @Override
    public String toString() {
        return "%s %s".formatted(prefecture.name(), addressLine);
    }
}
