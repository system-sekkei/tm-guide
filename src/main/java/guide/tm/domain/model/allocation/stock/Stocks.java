package guide.tm.domain.model.allocation.stock;

import guide.tm.domain.model.allocation.location.AllocatedLocation;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
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

    /**
     * 引当する
     *
     * 引当して、引当場所のリストを返却する
     */
    public AllocatedLocations allocate(Quantity orderedQuantity) {
        List<AllocatedLocation> result = new ArrayList<>();
        Quantity remaining = orderedQuantity;
        for (Stock stock : list) {
            if (stock.quantity.isGreaterEqualThan(remaining)) {
                result.add(new AllocatedLocation(stock.wareHouseCode, remaining));
                break;
            }
            result.add(new AllocatedLocation(stock.wareHouseCode, stock.quantity));
            remaining = remaining.subtract(stock.quantity);
        }
        return new AllocatedLocations(result);
    }

}
