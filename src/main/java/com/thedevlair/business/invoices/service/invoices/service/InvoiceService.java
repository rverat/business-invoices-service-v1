package com.thedevlair.business.invoices.service.invoices.service;

import com.thedevlair.business.invoices.service.invoices.model.Invoice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InvoiceService {

    Flux<Invoice> findAll();

    Mono<Invoice> findById(String id);

    Mono<Void> saveInvoce(Invoice Invoice);

}
