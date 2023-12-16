package com.thedevlair.business.invoices.service.invoices.util;

import com.thedevlair.apache.avro.model.Order;
import com.thedevlair.business.invoices.service.invoices.model.Invoice;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class InvoiceBuilder {

    public Invoice buildInvoice(Order order) {
        return Invoice.builder()
                .orderId(order.getId().toString())
                .customerId(order.getCustomerId().toString())
                .courseId(order.getId().toString())
                .date(new Date())
                .amount(new BigDecimal("123.45"))
                .build();
    }
}
