package com.darwing.Assessment.infrastructure.abst_services.generics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadAllService<Response> {
    Page<Response> getAll(Pageable pageable); 
}