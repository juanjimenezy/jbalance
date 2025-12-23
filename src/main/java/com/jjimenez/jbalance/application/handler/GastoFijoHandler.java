package com.jjimenez.jbalance.application.handler;

import com.jjimenez.jbalance.application.usecase.GastoFijoUseCase;
import com.jjimenez.jbalance.domain.model.GastoFijo;
import reactor.core.publisher.Mono;

public class GastoFijoHandler implements IGastoFijoHandler{
    private final GastoFijoUseCase gastoFijoUseCase;
    public GastoFijoHandler(GastoFijoUseCase gastoFijoUseCase) {
        this.gastoFijoUseCase = gastoFijoUseCase;
    }

    @Override
    public Mono<GastoFijo> guardarGastoFijo(GastoFijo gastoFijo) {
        return null;
    }

    @Override
    public Mono<GastoFijo> obtenerGastoFijoPorId(Long id) {
        return null;
    }
}
