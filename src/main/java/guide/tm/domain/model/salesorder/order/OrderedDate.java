package guide.tm.domain.model.salesorder.order;

import java.time.LocalDate;

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
}
