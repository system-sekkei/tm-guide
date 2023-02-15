package guide.tm.application.service.stock;

import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.product.individual.SingleProduct;
import org.springframework.stereotype.Service;

/**
 * 在庫サービス
 */
@Service
public class StockService {

    StockRepository stockRepository;

    StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * 在庫を取得する
     */
    public Stocks stocksOf(SingleProduct singleProduct) {
        return stockRepository.stocksOf(singleProduct);
    }

    /**
     * 在庫を登録する
     */
    public void register(Stock stock) {
        stockRepository.register(stock);
    }
}
