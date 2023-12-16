package com.thedevlair.business.invoices.service.invoices.dao;

import com.thedevlair.business.invoices.service.invoices.model.InvoiceDOC;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends ReactiveMongoRepository<InvoiceDOC, String> {

}
