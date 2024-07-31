package com.darwing.Assessment.infrastructure.abst_services.generics;

public interface DeleteService<Id> {
    void delete(Id id);
}