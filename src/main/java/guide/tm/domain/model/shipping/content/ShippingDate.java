package guide.tm.domain.model.shipping.content;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 出荷日
 */
public class ShippingDate {
    LocalDate value;

    ShippingDate() {
    }

    public ShippingDate(LocalDate value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.format(DateTimeFormatter.ISO_DATE);
    }
}
