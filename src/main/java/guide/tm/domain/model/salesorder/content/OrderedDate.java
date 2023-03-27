package guide.tm.domain.model.salesorder.content;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 受注日
 */
public class OrderedDate {
    LocalDate value;

    public OrderedDate() {
    }

    public OrderedDate(String value) {
        this.value = LocalDate.parse(value);
    }

    @Override
    public String toString() {
        if (value == null) return "";
        return value.format(DateTimeFormatter.ISO_DATE);
    }

    public boolean isEmpty() {
        return value == null;
    }

    public boolean isEqual(OrderedDate other) {
        return value.isEqual(other.value);
    }
}
