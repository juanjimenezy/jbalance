package com.jjimenez.jbalance.application.handler;

import com.jjimenez.jbalance.domain.model.Movimiento;
import reactor.core.publisher.Mono;

public interface IMovimientoHandler {

    Mono<Movimiento> buscarMovimientoPorId(Long id);
    Mono<Movimiento> guardarMovimiento(Movimiento movimiento);
}
