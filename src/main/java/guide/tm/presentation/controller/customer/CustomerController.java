package guide.tm.presentation.controller.customer;

import guide.tm.application.service.customer.CustomerService;
import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.customer.CustomerSearchCriteria;
import guide.tm.domain.model.customer.CustomerSummaries;
import guide.tm.domain.primitive.contact.Prefecture;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customers")
class CustomerController {

    CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ModelAttribute("prefectures")
    Prefecture[] prefectures() {
        return Prefecture.values();
    }

//    @ModelAttribute("customerSearchCriteria")
//    CustomerSearchCriteria customerSearchCriteria() {
//        return new CustomerSearchCriteria();
//    }

    @GetMapping("new")
    String newCustomer(@ModelAttribute("customer")Customer customer) {
        return "customer/new-customer";
    }

    @GetMapping
    String searchBy(@ModelAttribute("customerSearchCriteria") CustomerSearchCriteria customerSearchCriteria,
                    Model model) {
        CustomerSummaries customerSummaries = customerService.customerSummaries(customerSearchCriteria);
        model.addAttribute("customerSummaries", customerSummaries);
        return "customer/customer-list";
    }

    @GetMapping("{customerId}")
    String customer(@PathVariable("customerId") CustomerId customerId,
                    Model model) {
        Customer customer = customerService.customerOf(customerId);
        model.addAttribute("customer", customer);
        return "customer/customer";
    }

    @InitBinder("customerSearchCriteria")
    void bindCustomerSearchCriteria(WebDataBinder binder) {
        binder.setAllowedFields(
                "customerName"
        );
    }

    @PostMapping
    String register(@ModelAttribute Customer customer) {
        customerService.register(customer);
        return "redirect:/customers";
    }

    @InitBinder("customer")
    void bindCustomer(WebDataBinder binder) {
        binder.setAllowedFields(
                "customerName.name.value",
                "customerName.nameKana.value",
                "contact.address.prefecture",
                "contact.address.addressLine",
                "contact.phoneNumber.value",
                "contact.personInCharge"
        );
    }
}
