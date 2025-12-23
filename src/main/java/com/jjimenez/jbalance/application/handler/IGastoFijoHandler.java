package com.jjimenez.jbalance.application.handler;

import com.jjimenez.jbalance.domain.model.GastoFijo;
import reactor.core.publisher.Mono;

public interface IGastoFijoHandler {

    Mono<GastoFijo> guardarGastoFijo(GastoFijo gastoFijo);
    Mono<GastoFijo> obtenerGastoFijoPorId(Long id);
}
