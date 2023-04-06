package guide.tm.domain.model.invoice;

import guide.tm.domain.model.salesorder.content.OrderedDate;

import java.time.YearMonth;

/**
 * 受注年月
 */
public class OrderedYearMonth {

    YearMonth value;

    @Deprecated OrderedYearMonth() {
    }

    public OrderedYearMonth(String value) {
//        this.value = LocalDate.parse(value + "-01");
        this.value = YearMonth.parse(value);
    }


    YearMonth yearMonth() {
        return YearMonth.from(value);
    }

    public OrderedDate startOfOrderedYearMonth() {
        return new OrderedDate(yearMonth().atDay(1));
    }

    public OrderedDate endOfOrderedYearMonth() {
        return new OrderedDate(yearMonth().atEndOfMonth());
    }

    @Override
    public String toString() {
        return yearMonth().toString();
    }
}
