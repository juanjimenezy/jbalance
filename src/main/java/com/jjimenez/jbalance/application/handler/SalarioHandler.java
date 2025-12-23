package com.jjimenez.jbalance.application.handler;

import com.jjimenez.jbalance.application.usecase.SalarioUseCase;
import com.jjimenez.jbalance.domain.model.Salario;
import reactor.core.publisher.Mono;

public class SalarioHandler implements ISalarioHandler{

    private final SalarioUseCase salarioUseCase;

    public SalarioHandler(SalarioUseCase salarioUseCase) {
        this.salarioUseCase = salarioUseCase;
    }

    @Override
    public Mono<Salario> obtenerSalarioPorId(Long id) {
        return salarioUseCase.obtenerSalarioPorId(id);
    }

    @Override
    public Mono<Salario> guardarSalario(Salario salario) {
        return salarioUseCase.guardarSalario(salario);
    }
}
