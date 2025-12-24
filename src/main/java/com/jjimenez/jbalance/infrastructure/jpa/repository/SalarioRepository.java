package com.jjimenez.jbalance.infrastructure.jpa.repository;

import com.jjimenez.jbalance.infrastructure.jpa.entity.SalarioEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SalarioRepository extends ReactiveCrudRepository<SalarioEntity, Long> {
    @Query("SELECT * FROM SALARIO WHERE estado = 'A'")
    Flux<SalarioEntity> findActivos();

}
