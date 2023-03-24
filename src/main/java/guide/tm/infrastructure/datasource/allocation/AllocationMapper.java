package guide.tm.infrastructure.datasource.allocation;

import guide.tm.domain.model.allocation.bundle.BundleAllocation;
import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.location.AllocatedLocation;
import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface AllocationMapper {

    void registerSingleAllocation(
            @Param("allocationNumber") UUID allocationNumber,
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("singleOrderItem") SingleOrderItem singleOrderItem);

    void registerSingleAllocationItem(
            @Param("allocationNumber") UUID allocationNumber,
            @Param("allocatedLocation") AllocatedLocation allocatedLocation);

    void registerBundleAllocation(
            @Param("allocationNumber") UUID allocationNumber,
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("bundleProductOrderItem") BundleProductOrderItem bundleProductOrderItem);

    void registerBundleAllocationItem(
            @Param("bundleAllocationNumber") BundleAllocationNumber bundleAllocationNumber,
            @Param("allocatedLocation") AllocatedLocation allocatedLocation,
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("singleProduct") SingleProduct singleProduct);

    List<SingleAllocation> singleAllocationsOf(
            @Param("salesOrderId") SalesOrderId salesOrderId);

    List<BundleAllocation> bundleAllocationsOf(
            @Param("salesOrderId") SalesOrderId salesOrderId);
}
