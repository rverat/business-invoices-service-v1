package com.thedevlair.business.invoices.service.web;

import com.thedevlair.business.invoices.service.invoices.model.Invoice;
import com.thedevlair.business.invoices.service.invoices.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/api/invoices")
public class InvoiceController {

    final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    @Operation(summary = "Get all invoices")
    public Flux<Invoice> findInvoices() {
        return invoiceService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a invoice by ID")
    public Mono<Invoice> getInvoicesById(@PathVariable String id) {
        return invoiceService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new invoice")
    public Mono<Void> createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoce(invoice);
    }

}
