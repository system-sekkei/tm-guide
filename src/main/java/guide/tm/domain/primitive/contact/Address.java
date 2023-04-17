package guide.tm.domain.primitive.contact;

/**
 * 住所
 */
public class Address {
    Prefecture prefecture;
    String addressLine;

    public Address() {
        this(Prefecture.北海道, "");
    }

    public Address(Prefecture prefecture, String addressLine) {
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
