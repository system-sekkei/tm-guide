package guide.tm.application.service.stock;

import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.product.Product;

public interface StockRepository {
    Stocks stocksOf(Product product);

    void register(Stock stock);
}
