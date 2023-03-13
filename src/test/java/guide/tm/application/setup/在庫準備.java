package guide.tm.application.setup;

import guide.tm.application.service.stock.StockService;
import guide.tm.domain.model.allocation.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class 在庫準備 {
    @Autowired
    StockService service;

    public void 在庫のテストデータの準備(Stock 在庫) {
        service.register(在庫);
    }

    public void 在庫のテストデータの準備(List<Stock> stocks) {
        stocks.forEach(在庫 -> service.register(在庫));
    }
}
