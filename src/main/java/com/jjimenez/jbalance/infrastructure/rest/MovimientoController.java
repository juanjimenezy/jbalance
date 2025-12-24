package com.jjimenez.jbalance.infrastructure.rest;

import com.jjimenez.jbalance.application.usecase.MovimientoUseCase;
import com.jjimenez.jbalance.domain.model.Movimiento;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/jbalance/api/movimiento")
public class MovimientoController {
    private final MovimientoUseCase movimientoUseCase;
    public MovimientoController(MovimientoUseCase movimientoUseCase) {
        this.movimientoUseCase = movimientoUseCase;
    }

    @GetMapping("{id}")
    public Mono<Movimiento> obtenerMovimientoPorId(@PathVariable Long id) {
        return movimientoUseCase.obtenerMovimientoPorId(id);
    }

    @PostMapping
    public Mono<Movimiento> crearMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoUseCase.guardarMovimiento(movimiento);
    }

    @GetMapping("/periodo/{periodo}")
    public Flux<Movimiento> obtenerMovimientosPorPeriodo(@PathVariable String periodo) {
        return movimientoUseCase.obtenerMovimientosPorPeriodo(periodo);
    }
}
