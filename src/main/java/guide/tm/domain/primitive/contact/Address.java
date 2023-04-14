package guide.tm.domain.primitive.contact;

/**
 * 住所
 */
public class Address {
    Prefecture prefecture;
    String addressLine;

    @Override
    public String toString() {
        return "%s %s".formatted(prefecture.name(), addressLine);
    }
}
