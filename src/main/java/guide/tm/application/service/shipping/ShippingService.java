package guide.tm.application.service.shipping;

import guide.tm.domain.model.allocation.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.allocation.status.single.SingleOrderItemStatusList;
import guide.tm.domain.model.shipping.content.Shipping;
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
    public ShippingNumber register(
            Shipping shipping,
            SingleOrderItemStatusList singleOrderItemStatusList,
            BundleOrderItemStatusList bundleOrderItemStatusList) {
        return shippingRepository.register(shipping, singleOrderItemStatusList, bundleOrderItemStatusList);
    }

}
