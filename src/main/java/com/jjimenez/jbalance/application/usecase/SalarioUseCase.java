package com.jjimenez.jbalance.application.usecase;

import com.jjimenez.jbalance.domain.model.Salario;
import com.jjimenez.jbalance.domain.model.gateways.SalarioGateway;
import reactor.core.publisher.Mono;

public class SalarioUseCase {
    private final SalarioGateway salarioGateway;
    public SalarioUseCase(SalarioGateway salarioGateway) {
        this.salarioGateway = salarioGateway;
    }

    public Mono<Salario> guardarSalario(Salario salario) {
        return salarioGateway.guardarSalario(salario);
    }
    public Mono<Salario> obtenerSalarioPorId(Long id) {
        return salarioGateway.buscarPorId(id);
    }
}
