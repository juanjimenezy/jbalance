package com.jjimenez.jbalance.domain.usecase;

import com.jjimenez.jbalance.domain.model.GastoFijo;
import com.jjimenez.jbalance.domain.model.gateways.GastoFijoGateway;
import reactor.core.publisher.Mono;

public class GastoFijoUseCase {
    private final GastoFijoGateway gastoFijoGateway;
    public GastoFijoUseCase(GastoFijoGateway gastoFijoGateway) {
        this.gastoFijoGateway = gastoFijoGateway;
    }

    public Mono<GastoFijo> obtenerGastoFijoPorId(Long id) {
        return gastoFijoGateway.buscarPorId(id);
    }

    public Mono<GastoFijo> guardarGastoFijo(GastoFijo gastoFijo) {
        return gastoFijoGateway.guardarGastoFijo(gastoFijo);
    }
}
