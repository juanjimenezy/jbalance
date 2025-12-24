package com.jjimenez.jbalance.infrastructure.rest;

import com.jjimenez.jbalance.application.usecase.SalarioUseCase;
import com.jjimenez.jbalance.domain.model.Salario;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/jbalance/api/salario")
public class SalarioController {

    private final SalarioUseCase salarioUseCase;
    public SalarioController(SalarioUseCase salarioUseCase) {
        this.salarioUseCase = salarioUseCase;
    }

    @GetMapping("/{id}")
    public Mono<Salario> obtenerSalarioPorId(@PathVariable("id") Long id) {
        return salarioUseCase.obtenerSalarioPorId(id);
    }

    @GetMapping
    public Flux<Salario> obtenerTodosLosSalarios() {
        return salarioUseCase.obtenerTodosLosSalarios();
    }

    @GetMapping("/activo")
    public Flux<Salario> obtenerSalariosActivos() {
        return salarioUseCase.obtenerSalariosActivos();
    }

    @PostMapping
    public Mono<Salario> guardarSalario(@RequestBody Salario salario) {
        return salarioUseCase.guardarSalario(salario);
    }

}
