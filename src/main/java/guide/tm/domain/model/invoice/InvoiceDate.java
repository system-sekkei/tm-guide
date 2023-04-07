package guide.tm.domain.model.invoice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 請求日
 */
public class InvoiceDate {

    LocalDate value;

    public InvoiceDate() {
    }

    public InvoiceDate(String value) {
        this.value = LocalDate.parse(value);
    }

    public InvoiceDate(LocalDate value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null) return "";
        return value.format(DateTimeFormatter.ISO_DATE);
    }

    public boolean isEmpty() {
        return value == null;
    }
}
