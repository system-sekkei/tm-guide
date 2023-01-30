package guide.tm.domain.model.allocation.stock;

import guide.tm.domain.model.allocation.allocation.Allocation;
import guide.tm.domain.model.allocation.allocation.Allocations;
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

    public Allocations allocate(Quantity orderedQuantity) {
        List<Allocation> result = new ArrayList<>();
        Quantity remaining = orderedQuantity;
        for (Stock stock : list) {
            if (stock.quantity.isGreaterEqualThan(remaining)) {
                result.add(new Allocation(stock.wareHouseCode, remaining));
                break;
            }
            result.add(new Allocation(stock.wareHouseCode, stock.quantity));
            remaining = remaining.subtract(stock.quantity);
        }
        return new Allocations(result);
    }

}
