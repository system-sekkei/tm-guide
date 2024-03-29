package guide.tm.presentation.controller.customer;

import guide.tm.application.service.customer.CustomerService;
import guide.tm.domain.model.customer.CustomerSearchCriteria;
import guide.tm.domain.model.customer.CustomerSummaries;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
class CustomerRestController {

    CustomerService customerService;

    CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    CustomerSummaries searchBy(@ModelAttribute("customerSearchCriteria") CustomerSearchCriteria customerSearchCriteria) {
        return customerService.customerSummaries(customerSearchCriteria);
    }

    @InitBinder("customerSearchCriteria")
    void bindCustomerSearchCriteria(WebDataBinder binder) {
        binder.setAllowedFields(
                "customerName"
        );
    }

}
