package com.darwing.Assessment.infrastructure.abst_services.generics;

public interface UpdateService<Request, Response, Id> {
    Response update(Id id, Request request);
}