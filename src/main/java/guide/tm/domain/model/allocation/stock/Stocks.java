package guide.tm.domain.model.allocation.stock;

import java.util.List;

/**
 * 在庫のリスト
 */
public class Stocks {

    List<Stock> list;

    public Stocks(List<Stock> list) {
        this.list = list;
    }
}
