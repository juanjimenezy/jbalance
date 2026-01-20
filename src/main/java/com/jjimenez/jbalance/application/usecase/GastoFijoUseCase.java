package com.jjimenez.jbalance.application.usecase;

import com.jjimenez.jbalance.domain.model.GastoFijo;
import com.jjimenez.jbalance.domain.model.gateways.GastoFijoGateway;
import reactor.core.publisher.Flux;
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

    public Flux<GastoFijo> obtenerTodosLosGastosFijos() {
        return gastoFijoGateway.buscarTodosLosGastosFijos()
                .filter(gastoFijo -> gastoFijo.getEstado().equals("A"));
    }

    public Flux<GastoFijo> obtenerGastosFijosPorPagarSegunPeriodo(String periodo) {
        return gastoFijoGateway.buscarGastosFijosPorPagarSegunPeriodo(periodo);
    }
}
