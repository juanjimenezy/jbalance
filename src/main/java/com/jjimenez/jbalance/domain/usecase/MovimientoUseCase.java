package com.jjimenez.jbalance.domain.usecase;

import com.jjimenez.jbalance.domain.model.Movimiento;
import com.jjimenez.jbalance.domain.model.gateways.MovimientoGateway;
import reactor.core.publisher.Mono;

public class MovimientoUseCase {
    private final MovimientoGateway movimientoGateway;
    public MovimientoUseCase(MovimientoGateway movimientoGateway) {
        this.movimientoGateway = movimientoGateway;
    }

    public Mono<Movimiento> obtenerMovimientoPorId(Long id) {
        return movimientoGateway.buscarPorId(id);
    }

    public Mono<Movimiento> guardarMovimiento(Movimiento movimiento) {
        return movimientoGateway.guardarMovimiento(movimiento);
    }
}
