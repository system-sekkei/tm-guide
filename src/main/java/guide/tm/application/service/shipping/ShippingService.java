package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.content.ShippingInstruction;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.summary.ShippingInstructionCriteria;
import org.springframework.stereotype.Service;

/**
 * 出荷指示サービス
 */
@Service
public class ShippingService {
    ShippingInstructionRepository shippingInstructionRepository;
    ShippingRepository shippingRepository;

    ShippingService(
            ShippingInstructionRepository shippingInstructionRepository,
            ShippingRepository shippingRepository) {
        this.shippingInstructionRepository = shippingInstructionRepository;
        this.shippingRepository = shippingRepository;
    }

    /**
     * 出荷指示を登録する
     */
    public ShippingNumber register(ShippingInstruction shippingInstruction) {
        return shippingInstructionRepository.register(shippingInstruction);
    }

    /**
     * 出荷指示のリストを取得する
     */
    public ShippingInstructionSummaries shippingInstructionSummaries(ShippingInstructionCriteria shippingInstructionCriteria) {
        return shippingInstructionRepository.shippingInstructionSummaries(shippingInstructionCriteria);
    }

    /**
     * 出荷済の指示を消しこむ
     */
    public void markAsShipped(ShippingNumber shippingNumber) {
        shippingRepository.markAsShipped(shippingNumber);
    }

    /**
     * 全明細が出荷指示済の受注を記録する
     */
    public void markAsInstructed(SalesOrderId salesOrderId) {
        shippingInstructionRepository.markAsInstructed(salesOrderId);
    }
}
