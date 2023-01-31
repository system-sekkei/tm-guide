package guide.tm.application.service.shipping.company;

import guide.tm.domain.model.shipping.company.ShippingCompany;

public interface ShippingCompanyRepository {
    void register(ShippingCompany shippingCompany);
}
