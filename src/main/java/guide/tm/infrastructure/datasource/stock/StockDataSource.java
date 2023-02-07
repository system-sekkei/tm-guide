package guide.tm.infrastructure.datasource.stock;

import guide.tm.application.service.stock.StockRepository;
import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.product.individual.IndividualProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockDataSource implements StockRepository {

    StockMapper stockMapper;

    StockDataSource(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    @Override
    public Stocks stocksOf(IndividualProduct individualProduct) {
        List<Stock> list = stockMapper.stocksOf(individualProduct);
        return new Stocks(list);
    }

    @Override
    public void register(Stock stock) {
        stockMapper.register(stock);
    }
}
