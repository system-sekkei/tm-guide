package guide.tm.infrastructure.datasource.invoice;

import guide.tm.application.service.invoice.InvoiceRepository;
import guide.tm.domain.model.invoice.InvoiceSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface InvoiceMapper {

    List<InvoiceSummary> invoicedSummaries(
            @Param("invoiceRepository") InvoiceRepository invoiceRepository);

    List<InvoiceSummary> notInvoicedSummaries(
            @Param("invoiceRepository") InvoiceRepository invoiceRepository);
}
