package guide.tm.application.scenario.allocation;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import org.springframework.stereotype.Service;

@Service
public class AllocationScenario {

    AllocationService allocationService;
    SalesOrderScenario salesOrderScenario;

    AllocationScenario(AllocationService allocationService, SalesOrderScenario salesOrderScenario) {
        this.allocationService = allocationService;
        this.salesOrderScenario = salesOrderScenario;
    }

    public void allocate(SalesOrderStatus salesOrderStatus, SalesOrderId salesOrderId) {
        allocationService.allocateSalesOrder(salesOrderStatus, salesOrderId);
        SalesOrderStatus status = salesOrderScenario.status(salesOrderId);
        if (status.isAllAllocated()) {
            allocationService.markAsCompleted(salesOrderId);
        }
    }
}
