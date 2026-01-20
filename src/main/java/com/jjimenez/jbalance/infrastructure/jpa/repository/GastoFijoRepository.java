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

    @Query("SELECT gf.* FROM GASTO_FIJO gf LEFT JOIN MOVIMIENTOS m ON m.id_gasto_fijo = gf.id and m.periodo = :periodo WHERE m.id IS NULL;" )
    Flux<GastoFijoEntity> findPorPagarByPeriodo(String periodo);
}
