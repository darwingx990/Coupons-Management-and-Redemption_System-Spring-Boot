package com.darwing.Assessment.infrastructure.abst_services.generics;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Id id);
}