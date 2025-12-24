package com.jjimenez.jbalance.domain.model.gateways;

import com.jjimenez.jbalance.domain.model.Movimiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovimientoGateway {
    Mono<Movimiento> buscarPorId(Long id);
    Mono<Movimiento> guardarMovimiento(Movimiento movimiento);
    Flux<Movimiento> buscarPorPeriodo(String periodo);
}
