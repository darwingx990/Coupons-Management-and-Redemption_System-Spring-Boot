package com.darwing.Assessment.util.exceptions;

public class IdNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "No results found in the entity [%s] with id %s.";

    public IdNotFoundException(String entityName, Long id) {
        super(String.format(ERROR_MESSAGE, entityName, id));
    }
}