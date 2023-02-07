package guide.tm.application.service.stock;

import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.product.individual.IndividualProduct;

public interface StockRepository {
    Stocks stocksOf(IndividualProduct individualProduct);

    void register(Stock stock);
}
