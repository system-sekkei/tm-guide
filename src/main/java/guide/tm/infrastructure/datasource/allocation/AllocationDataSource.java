package guide.tm.infrastructure.datasource.allocation;

import guide.tm.application.service.allocation.AllocationRepository;
import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.salesorder.SalesOrderItem;
import guide.tm.domain.model.salesorder.SalesOrderNumber;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AllocationDataSource implements AllocationRepository {

    AllocationMapper allocationMapper;

    AllocationDataSource(AllocationMapper allocationMapper) {
        this.allocationMapper = allocationMapper;
    }

    @Override
    public void register(Allocations allocations, SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem) {
        allocations.list().forEach(allocation -> {
            UUID allocationId = UUID.randomUUID();
            allocationMapper.register(allocationId, allocation, salesOrderNumber, salesOrderItem);
            allocationMapper.recordAllocatedStock(allocationId, allocation, salesOrderItem);
        });
    }
}
