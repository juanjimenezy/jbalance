package com.jjimenez.jbalance.application.usecase;

import com.jjimenez.jbalance.domain.model.Movimiento;
import com.jjimenez.jbalance.domain.model.gateways.GastoFijoGateway;
import com.jjimenez.jbalance.domain.model.gateways.MovimientoGateway;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public class MovimientoUseCase {
    private final MovimientoGateway movimientoGateway;
    private final GastoFijoGateway gastoFijoGateway;
    public MovimientoUseCase(MovimientoGateway movimientoGateway, GastoFijoGateway gastoFijoGateway) {
        this.movimientoGateway = movimientoGateway;
        this.gastoFijoGateway = gastoFijoGateway;
    }

    public Mono<Movimiento> obtenerMovimientoPorId(Long id) {
        return movimientoGateway.buscarPorId(id);
    }
    public Flux<Movimiento> obtenerMovimientosPorPeriodo(String periodo) {
        return movimientoGateway.buscarPorPeriodo(periodo);
    }
    public Mono<Movimiento> guardarMovimiento(Movimiento movimiento) {
        return gastoFijoGateway.buscarPorId(movimiento.getIdGastoFijo())
                .flatMap(g -> {
                    if (g.getId() != 0L){
                        movimiento.setDescripcion(g.getConcepto());
                        movimiento.setValor(g.getValor());
                    }
                    movimiento.setFecha(LocalDate.now());
                    return movimientoGateway.guardarMovimiento(movimiento);
                });


    }
}
