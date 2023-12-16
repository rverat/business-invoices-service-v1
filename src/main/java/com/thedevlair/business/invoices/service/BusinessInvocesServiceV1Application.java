package com.thedevlair.business.invoices.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Business Invoices API", version = "1.0.0"))
public class BusinessInvocesServiceV1Application {

    public static void main(String[] args) {
        SpringApplication.run(BusinessInvocesServiceV1Application.class, args);
    }

}
