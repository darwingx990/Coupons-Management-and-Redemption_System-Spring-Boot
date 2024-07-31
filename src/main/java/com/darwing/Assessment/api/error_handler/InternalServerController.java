package com.darwing.Assessment.api.error_handler;

import com.darwing.Assessment.api.dto.errors.BaseErrorsResponse;
import com.darwing.Assessment.api.dto.errors.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerController {
    @ExceptionHandler(CannotCreateTransactionException.class)
    public BaseErrorsResponse handleCannotCreateTransactionException(CannotCreateTransactionException ex) {
        return ErrorResponse.builder()
                .message("A transaction could not be opened for the database. Please try again later.")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
}