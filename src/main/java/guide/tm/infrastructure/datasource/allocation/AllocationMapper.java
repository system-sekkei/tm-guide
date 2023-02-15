package guide.tm.infrastructure.datasource.allocation;

import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.location.AllocatedLocation;
import guide.tm.domain.model.product.individual.SingleProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
interface AllocationMapper {

    void registerSingleAllocation(
            @Param("allocationNumber") UUID allocationNumber,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("singleOrderItem") SingleOrderItem singleOrderItem);

    void registerSingleAllocationItem(
            @Param("allocationNumber") UUID allocationNumber,
            @Param("allocatedLocation") AllocatedLocation allocatedLocation);

    void registerBundleAllocation(
            @Param("allocationNumber") UUID allocationNumber,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("bundleProductOrderItem") BundleProductOrderItem bundleProductOrderItem);

    void registerBundleAllocationItem(
            @Param("bundleAllocationNumber") BundleAllocationNumber bundleAllocationNumber,
            @Param("allocatedLocation") AllocatedLocation allocatedLocation,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("singleProduct") SingleProduct singleProduct);

}
