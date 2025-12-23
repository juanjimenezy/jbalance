package com.jjimenez.jbalance.application.handler;

import com.jjimenez.jbalance.domain.model.Salario;
import reactor.core.publisher.Mono;

public interface ISalarioHandler {
    public Mono<Salario> obtenerSalarioPorId(Long id);
    public Mono<Salario> guardarSalario(Salario salario);
}
