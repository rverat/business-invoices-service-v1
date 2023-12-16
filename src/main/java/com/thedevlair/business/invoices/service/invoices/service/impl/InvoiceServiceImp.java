package com.thedevlair.business.invoices.service.invoices.service.impl;

import com.thedevlair.business.invoices.service.invoices.dao.InvoiceRepository;
import com.thedevlair.business.invoices.service.invoices.exception.types.NotFoundException;
import com.thedevlair.business.invoices.service.invoices.mapper.InvoiceMapper;
import com.thedevlair.business.invoices.service.invoices.model.Invoice;
import com.thedevlair.business.invoices.service.invoices.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvoiceServiceImp implements InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImp.class);
    private static final String COURSE_NOT_FOUND_MESSAGE = "Invoice with ID %s does not exist";
    final InvoiceRepository invoiceRepository;
    final InvoiceMapper invoiceMapper;

    public InvoiceServiceImp(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public Flux<Invoice> findAll() {
        return invoiceRepository.findAll()
                .map(invoiceMapper::toBusiness);
    }

    @Override
    public Mono<Invoice> findById(String id) {
        return invoiceRepository.findById(id)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new NotFoundException(COURSE_NOT_FOUND_MESSAGE, id))
                ))
                .map(invoiceMapper::toBusiness);
    }

    @Override
    @Transactional
    public Mono<Void> saveInvoce(Invoice invoice) {
        return invoiceRepository.save(invoiceMapper.toDOC(invoice))
                .doOnSuccess(invoiceSaved -> {
                    logger.info("Invoice created successfully. Access it at: " + invoiceSaved.getId());
                })
                .onErrorResume(throwable -> {
                    logger.error("Failed to create invoice: " + throwable.getMessage());
                    return Mono.error(new RuntimeException("Failed to create invoice", throwable));
                })
                .then();
    }
}
