package com.jjimenez.jbalance.domain.model.gateways;

import com.jjimenez.jbalance.domain.model.GastoFijo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GastoFijoGateway {
    Mono<GastoFijo> buscarPorId(Long id);
    Mono<GastoFijo> guardarGastoFijo(GastoFijo gastoFijo);
    Flux<GastoFijo> buscarTodosLosGastosFijos();
    Flux<GastoFijo> buscarGastosFijosPorPagarSegunPeriodo(String periodo);
}
