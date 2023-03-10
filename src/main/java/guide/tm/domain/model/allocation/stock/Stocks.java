package guide.tm.domain.model.allocation.stock;

import guide.tm.domain.model.allocation.location.AllocatedLocation;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.salesorder.content.ShippingAddress;
import guide.tm.domain.primitive.Quantity;

import java.util.ArrayList;
import java.util.Comparator;
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
     * 届け先住所に近い倉庫から引当を行う
     */
    public AllocatedLocations allocate(ShippingAddress shippingAddress, Quantity orderedQuantity) {
        Stocks stocks = sortByCloserTo(shippingAddress);
        return stocks.allocate(orderedQuantity);
    }

    /**
     * 引当場所のリストを返却する
     */
    AllocatedLocations allocate(Quantity orderedQuantity) {
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

    /**
     * 在庫を届け先に近い順にソートする
     */
    Stocks sortByCloserTo(ShippingAddress shippingAddress) {
        return new Stocks(
                list.stream()
                        .sorted(Comparator.comparingInt(stock -> stock.wareHousePrefecture.distanceFrom(shippingAddress.prefecture())))
                        .toList()
        );
    }

    public List<Stock> list() {
        return list;
    }
}
