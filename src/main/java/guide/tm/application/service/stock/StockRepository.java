package guide.tm.application.service.stock;

import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.product.individual.SingleProduct;

public interface StockRepository {
    Stocks stocksOf(SingleProduct singleProduct);

    void register(Stock stock);
}
