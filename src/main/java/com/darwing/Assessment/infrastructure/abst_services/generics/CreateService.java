package com.darwing.Assessment.infrastructure.abst_services.generics;

public interface CreateService<Request, Response> {
    Response create(Request request);
}