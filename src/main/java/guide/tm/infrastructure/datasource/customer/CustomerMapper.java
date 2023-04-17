package guide.tm.infrastructure.datasource.customer;

import guide.tm.domain.model.customer.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface CustomerMapper {

    void register(
            @Param("customer") Customer customer,
            @Param("customerId") CustomerId customerId,
            @Param("customerNumber") CustomerNumber customerNumber);

    List<CustomerSummary> summaries();

    List<CustomerSummary> customerSummariesOf(
            @Param("customerSearchCriteria") CustomerSearchCriteria customerSearchCriteria);

    long newCustomerNumber();

    Customer customerOf(@Param("customerId") CustomerId customerId);

    void registerContact(
            @Param("customer") Customer customer,
            @Param("customerId") CustomerId customerId);
}
