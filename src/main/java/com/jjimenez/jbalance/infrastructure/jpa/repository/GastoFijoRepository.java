package com.jjimenez.jbalance.infrastructure.jpa.repository;

import com.jjimenez.jbalance.infrastructure.jpa.entity.GastoFijoEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface GastoFijoRepository extends ReactiveCrudRepository<GastoFijoEntity, Long> {
    @Query("SELECT * FROM GASTO_FIJO WHERE estado = 'A'")
    Flux<GastoFijoEntity> findActivos();
}
