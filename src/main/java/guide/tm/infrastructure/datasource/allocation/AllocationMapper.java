package guide.tm.infrastructure.datasource.allocation;

import guide.tm.domain.model.allocation.allocation.Allocation;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
interface AllocationMapper {

    void register(
            @Param("allocationId") UUID allocationId,
            @Param("allocation") Allocation allocation,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("salesOrderItem") SalesOrderItem salesOrderItem);

    void recordAllocatedStock(
            @Param("allocationId") UUID allocationId,
            @Param("allocation") Allocation allocation,
            @Param("salesOrderItem") SalesOrderItem salesOrderItem);
}
