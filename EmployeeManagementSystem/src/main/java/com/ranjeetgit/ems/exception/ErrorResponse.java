package com.ranjeetgit.ems.exception;

import java.time.LocalDate;

public record ErrorResponse(int status, String message, LocalDate date) {
}
