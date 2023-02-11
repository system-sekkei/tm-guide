package guide.tm.application.scenario.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.application.service.shipping.ShippingService;
import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.allocation.allocation.BundleAllocations;
import guide.tm.domain.model.allocation.allocation.SalesOrderAllocation;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingDate;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItem;
import guide.tm.domain.model.shipping.item.ShippingItems;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShippingScenario {

    ShippingService shippingService;
    ShippingItemService shippingItemService;
    SalesOrderScenario salesOrderScenario;
    AllocationService allocationService;

    ShippingScenario(
            ShippingService shippingService,
            ShippingItemService shippingItemService,
            SalesOrderScenario salesOrderScenario,
            AllocationService allocationService) {
        this.shippingService = shippingService;
        this.shippingItemService = shippingItemService;
        this.salesOrderScenario = salesOrderScenario;
        this.allocationService = allocationService;
    }

    /**
     * 出荷を登録する
     */
    public void registerShippingOf(SalesOrderNumber salesOrderNumber) {
        ShippingItems shippedItems = shippingItemService.shippingItems(salesOrderNumber);
        SalesOrderAllocation salesOrderAllocation = salesOrderAllocation(salesOrderNumber);
        SalesOrderItems salesOrderItems = salesOrderAllocation.salesOrderItemAllocations().allocatedSaleOrderItems();
        ShippingItems shippingItems = new ShippingItems(salesOrderItems.list().stream().map(ShippingItem::from).toList());
        ShippingItems toBeShipped = shippingItems.toBeShipped(shippedItems);
        if (salesOrderItems.isEmpty()) return;
        ShippingNumber shippingNumber =
                shippingService.register(new Shipping(new ShippingDate(LocalDate.now())));
        shippingService.registerItems(shippingNumber, salesOrderAllocation.salesOrderNumber(), toBeShipped);
    }

    SalesOrderAllocation salesOrderAllocation(SalesOrderNumber salesOrderNumber) {
        SalesOrder salesOrder = salesOrderScenario.salesOrderOf(salesOrderNumber);
        Allocations allocations = allocationService.allocationsOf(salesOrderNumber);
        BundleAllocations bundleAllocations = allocationService.bundleAllocations(salesOrderNumber);
        return new SalesOrderAllocation(salesOrderNumber, salesOrder, allocations, bundleAllocations);
    }
}
