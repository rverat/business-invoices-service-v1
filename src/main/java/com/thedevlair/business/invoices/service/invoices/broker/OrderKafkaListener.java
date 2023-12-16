package com.thedevlair.business.invoices.service.invoices.broker;

import com.thedevlair.apache.avro.model.Order;
import com.thedevlair.business.invoices.service.invoices.service.InvoiceService;
import com.thedevlair.business.invoices.service.invoices.util.InvoiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderKafkaListener {

    private final Logger logger = LoggerFactory.getLogger(OrderKafkaListener.class);

    private final InvoiceService invoiceService;
    private final InvoiceBuilder invoiceBuilder;

    public OrderKafkaListener(InvoiceService invoiceService, InvoiceBuilder invoiceBuilder) {
        this.invoiceService = invoiceService;
        this.invoiceBuilder = invoiceBuilder;
    }

    @KafkaListener(topics = {"order"}, groupId = "order-group")
    public void consume(@Payload Order order) {

        logger.info(String.format("Read message to Kafka ID: %s", order.getId()));

        invoiceService.saveInvoce(invoiceBuilder.buildInvoice(order))
                .doOnSuccess(voidResult -> {
                    logger.info("Saved invoice in the database");
                })
                .subscribe();
        logger.info("saved invoice in data base");


    }

}
