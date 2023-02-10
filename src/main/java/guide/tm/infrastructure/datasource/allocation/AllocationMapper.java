package guide.tm.infrastructure.datasource.allocation;

import guide.tm.domain.model.allocation.allocation.Allocation;
import guide.tm.domain.model.allocation.allocation.AllocationContent;
import guide.tm.domain.model.product.individual.IndividualProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface AllocationMapper {

    void register(
            @Param("allocationId") UUID allocationId,
            @Param("allocationContent") AllocationContent allocationContent,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("salesOrderItemNumber") SalesOrderItemNumber salesOrderItemNumber,
            @Param("product") IndividualProduct product
    );

    void recordAllocatedStock(
            @Param("allocationId") UUID allocationId,
            @Param("allocationContent") AllocationContent allocationContent,
            @Param("product") IndividualProduct product);

    List<Allocation> allocationsOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    void registerBundleProduct(
            @Param("allocationId") UUID allocationId,
            @Param("allocationContent") AllocationContent allocationContent,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("salesOrderItemNumber") SalesOrderItemNumber salesOrderItemNumber,
            @Param("product") IndividualProduct product
    );

}
