package com.jjimenez.jbalance.domain.model.gateways;

import com.jjimenez.jbalance.domain.model.Salario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SalarioGateway {
    Mono<Salario> buscarPorId(Long id);
    Mono<Salario> guardarSalario(Salario salario);
    Flux<Salario> buscarTodosLosSalarios();
    Flux<Salario> buscarSalarioActivos();
}
