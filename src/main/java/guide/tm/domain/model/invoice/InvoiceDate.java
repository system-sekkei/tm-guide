package guide.tm.domain.model.invoice;

import java.time.YearMonth;

/**
 * 請求日
 */
public class InvoiceDate {

    YearMonth value;

    public InvoiceDate(YearMonth value) {
        this.value = value;
    }
}
