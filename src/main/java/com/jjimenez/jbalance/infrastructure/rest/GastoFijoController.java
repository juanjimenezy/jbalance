package com.jjimenez.jbalance.infrastructure.rest;

import com.jjimenez.jbalance.application.usecase.GastoFijoUseCase;
import com.jjimenez.jbalance.domain.model.GastoFijo;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/jbalance/api/gasto-fijo")
public class GastoFijoController {
    private final GastoFijoUseCase gastoFijoUseCase;

    public GastoFijoController(GastoFijoUseCase gastoFijoUseCase) {
        this.gastoFijoUseCase = gastoFijoUseCase;
    }

    @GetMapping("/{id}")
    public Mono<GastoFijo> obtenerGastosFijosPorId(@PathVariable("id") Long id) {
        return gastoFijoUseCase.obtenerGastoFijoPorId(id);
    }

    @PostMapping
    public Mono<GastoFijo> guardarGastoFijo(@RequestBody GastoFijo gastoFijo) {
        return gastoFijoUseCase.guardarGastoFijo(gastoFijo);
    }
    
    @GetMapping("/all")
    public Flux<GastoFijo> obtenerTodosLosGastosFijos() {
        return gastoFijoUseCase.obtenerTodosLosGastosFijos();
    }


}
