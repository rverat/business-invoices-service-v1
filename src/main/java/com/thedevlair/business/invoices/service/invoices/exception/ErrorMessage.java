package com.thedevlair.business.invoices.service.invoices.exception;

import java.util.Date;

public record ErrorMessage(int statusCode, Date timestamp, String message) {
}
