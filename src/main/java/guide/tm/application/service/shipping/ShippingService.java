package guide.tm.application.service.shipping;

import guide.tm.domain.model.shipping.content.ShippingInstruction;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import org.springframework.stereotype.Service;

/**
 * 出荷指示サービス
 */
@Service
public class ShippingService {
    ShippingRepository shippingRepository;

    ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    /**
     * 出荷指示を登録する
     */
    public ShippingNumber register(ShippingInstruction shippingInstruction) {
        return shippingRepository.register(shippingInstruction);
    }

    /**
     * 出荷指示のリストを取得する
     */
    public ShippingInstructionSummaries shippingInstructionSummaries() {
        return shippingRepository.shippingInstructionSummaries();
    }

    /**
     * 出荷済の指示を消しこむ
     */
    public void markShipping(ShippingNumber shippingNumber) {
        shippingRepository.markShipping(shippingNumber);
    }

}
