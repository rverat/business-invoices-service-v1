package com.thedevlair.business.invoices.service.invoices.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "invoices")
public class InvoiceDOC {

    @Id
    private String id;

    @NotNull
    private String orderId;

    @NotNull
    private String customerId;

    @NotNull
    private String courseId;

    private Date date;

    private BigDecimal amount;

}
