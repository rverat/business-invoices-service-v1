package com.thedevlair.business.invoices.service.invoices.mapper;

import com.thedevlair.business.invoices.service.invoices.model.Invoice;
import com.thedevlair.business.invoices.service.invoices.model.InvoiceDOC;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    Invoice toBusiness(InvoiceDOC invoiceDOC);

    InvoiceDOC toDOC(Invoice invoice);
}
