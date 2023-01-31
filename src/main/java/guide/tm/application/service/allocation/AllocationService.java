package guide.tm.application.service.allocation;

import guide.tm.application.service.stock.StockService;
import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.salesorder.SalesOrderItem;
import guide.tm.domain.model.salesorder.SalesOrderNumber;
import org.springframework.stereotype.Service;

/**
 * 引当サービス
 */
@Service
public class AllocationService {

    StockService stockService;
    AllocationRepository allocationRepository;

    AllocationService(StockService stockService, AllocationRepository allocationRepository) {
        this.stockService = stockService;
        this.allocationRepository = allocationRepository;
    }

    /**
     * 引当する
     */
    public void allocate(SalesOrderItem salesOrderItem, SalesOrderNumber salesOrderNumber) {
        Stocks stocks = stockService.stocksOf(salesOrderItem.product());
        Allocations allocations = stocks.allocate(salesOrderItem.quantity());
        allocationRepository.register(allocations, salesOrderNumber, salesOrderItem);
    }
}