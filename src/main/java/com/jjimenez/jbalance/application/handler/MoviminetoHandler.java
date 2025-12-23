package com.jjimenez.jbalance.application.handler;

import com.jjimenez.jbalance.application.usecase.MovimientoUseCase;
import com.jjimenez.jbalance.domain.model.Movimiento;
import reactor.core.publisher.Mono;

public class MoviminetoHandler implements IMovimientoHandler{
    private final MovimientoUseCase movimientoUseCase;
    public MoviminetoHandler(MovimientoUseCase movimientoUseCase) {
        this.movimientoUseCase = movimientoUseCase;
    }

    @Override
    public Mono<Movimiento> buscarMovimientoPorId(Long id) {
        return movimientoUseCase.obtenerMovimientoPorId(id);
    }

    @Override
    public Mono<Movimiento> guardarMovimiento(Movimiento movimiento) {
        return movimientoUseCase.guardarMovimiento(movimiento);
    }
}
