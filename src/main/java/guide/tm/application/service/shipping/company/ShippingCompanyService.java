package guide.tm.application.service.shipping.company;

import guide.tm.domain.model.shipping.company.ShippingCompany;
import org.springframework.stereotype.Service;

/**
 * 運送会社サービス
 */
@Service
public class ShippingCompanyService {

    ShippingCompanyRepository shippingCompanyRepository;

    ShippingCompanyService(ShippingCompanyRepository shippingCompanyRepository) {
        this.shippingCompanyRepository = shippingCompanyRepository;
    }

    public void register(ShippingCompany shippingCompany) {
        shippingCompanyRepository.register(shippingCompany);
    }
}
