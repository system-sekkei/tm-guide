package guide.tm.domain.model.allocation.stock;

import guide.tm.domain.model.allocation.allocation.AllocationContent;
import guide.tm.domain.model.allocation.allocation.AllocationContents;
import guide.tm.domain.model.primitive.Quantity;

import java.util.ArrayList;
import java.util.List;

/**
 * 在庫のリスト
 */
public class Stocks {

    List<Stock> list;

    public Stocks(List<Stock> list) {
        this.list = list;
    }

    public AllocationContents allocate(Quantity orderedQuantity) {
        List<AllocationContent> result = new ArrayList<>();
        Quantity remaining = orderedQuantity;
        for (Stock stock : list) {
            if (stock.quantity.isGreaterEqualThan(remaining)) {
                result.add(new AllocationContent(stock.wareHouseCode, remaining));
                break;
            }
            result.add(new AllocationContent(stock.wareHouseCode, stock.quantity));
            remaining = remaining.subtract(stock.quantity);
        }
        return new AllocationContents(result);
    }

}
