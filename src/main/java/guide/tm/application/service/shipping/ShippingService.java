package guide.tm.application.service.shipping;

import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import org.springframework.stereotype.Service;

/**
 * 出荷サービス
 */
@Service
public class ShippingService {
    ShippingRepository shippingRepository;

    ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    /**
     * 出荷を登録する
     */
    public ShippingNumber register(Shipping shipping) {
        return shippingRepository.register(shipping);
    }

    /**
     * 出荷を取得する
     */
    public Shipping shippingOf(ShippingNumber shippingNumber) {
        return shippingRepository.shippingOf(shippingNumber);
    }
}
