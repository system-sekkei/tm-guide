package guide.tm.infrastructure.datasource.shipping;

import guide.tm.domain.model.shipping.content.ShippingNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
interface ShippingMapper {

    void markAsShipped(
            @Param("shippingNumber") ShippingNumber shippingNumber);

    void deleteUnshippingState(
            @Param("shippingNumber") ShippingNumber shippingNumber);
}
