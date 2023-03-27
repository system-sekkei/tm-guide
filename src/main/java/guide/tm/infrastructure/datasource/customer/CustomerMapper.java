package guide.tm.infrastructure.datasource.customer;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerNumber;
import guide.tm.domain.model.customer.CustomerSearchCriteria;
import guide.tm.domain.model.customer.CustomerSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface CustomerMapper {

    void register(
            @Param("customer") Customer customer,
            @Param("customerNumber") CustomerNumber customerNumber);

    List<CustomerSummary> summaries();

    List<CustomerSummary> customerSummariesOf(
            @Param("customerSearchCriteria") CustomerSearchCriteria customerSearchCriteria);

    long newCustomerNumber();
}
