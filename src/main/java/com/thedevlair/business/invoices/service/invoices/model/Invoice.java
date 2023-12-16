package com.thedevlair.business.invoices.service.invoices.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

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
