package guide.tm.infrastructure.datasource.shipping.company;

import guide.tm.domain.model.shipping.company.ShippingCompany;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
interface ShippingCompanyMapper {

    void register(@Param("shippingCompany") ShippingCompany shippingCompany);
}
