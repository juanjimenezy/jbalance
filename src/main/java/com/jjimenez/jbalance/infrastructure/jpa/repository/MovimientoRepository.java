package com.jjimenez.jbalance.infrastructure.jpa.repository;

import com.jjimenez.jbalance.infrastructure.jpa.entity.MovimientoEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MovimientoRepository extends ReactiveCrudRepository<MovimientoEntity, Long> {
    @Query("SELECT * FROM movimientos WHERE periodo LIKE :periodo || '%'")
    Flux<MovimientoEntity> findByPeriodo(String periodo);
}
