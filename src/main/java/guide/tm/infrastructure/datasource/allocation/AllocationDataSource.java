package guide.tm.infrastructure.datasource.allocation;

import guide.tm.application.service.allocation.AllocationRepository;
import guide.tm.domain.model.allocation.allocation.AllocationContents;
import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AllocationDataSource implements AllocationRepository {

    AllocationMapper allocationMapper;

    AllocationDataSource(AllocationMapper allocationMapper) {
        this.allocationMapper = allocationMapper;
    }

    @Override
    public void register(AllocationContents allocationContents, SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem) {
        allocationContents.list().forEach(allocationContent -> {
            UUID allocationId = UUID.randomUUID();
            allocationMapper.register(allocationId, allocationContent, salesOrderNumber, salesOrderItem);
            allocationMapper.recordAllocatedStock(allocationId, allocationContent, salesOrderItem);
        });
    }

    @Override
    public Allocations allocationsOf(SalesOrderNumber salesOrderNumber) {
        return new Allocations(allocationMapper.allocationsOf(salesOrderNumber));
    }
}
