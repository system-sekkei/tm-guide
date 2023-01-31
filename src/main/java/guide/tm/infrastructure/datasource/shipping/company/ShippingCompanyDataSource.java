package guide.tm.infrastructure.datasource.shipping.company;

import guide.tm.application.service.shipping.company.ShippingCompanyRepository;
import guide.tm.domain.model.shipping.company.ShippingCompany;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingCompanyDataSource implements ShippingCompanyRepository {

    ShippingCompanyMapper shippingCompanyMapper;

    ShippingCompanyDataSource(ShippingCompanyMapper shippingCompanyMapper) {
        this.shippingCompanyMapper = shippingCompanyMapper;
    }

    @Override
    public void register(ShippingCompany shippingCompany) {
        shippingCompanyMapper.register(shippingCompany);
    }
}
