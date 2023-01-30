package guide.tm.application


import guide.tm.application.service.stock.StockService
import guide.tm.domain.model.allocation.stock.Stock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class StockSetup {

    @Autowired
    StockService service

    def "在庫のテストデータの準備"(Stock 在庫) {
        service.register(在庫)
    }

    def "在庫のテストデータの準備"(List<Stock> stocks) {
        stocks.forEach(在庫 -> service.register(在庫))
    }
}
