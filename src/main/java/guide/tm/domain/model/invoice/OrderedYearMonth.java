package guide.tm.domain.model.invoice;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 受注年月
 */
public class OrderedYearMonth {

    LocalDate value;

    YearMonth yearMonth() {
        return YearMonth.from(value);
    }

    @Override
    public String toString() {
        return yearMonth().toString();
    }
}
