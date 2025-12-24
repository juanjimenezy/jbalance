package com.jjimenez.jbalance.infrastructure.jpa.adapter;

import com.jjimenez.jbalance.domain.model.Salario;
import com.jjimenez.jbalance.domain.model.gateways.SalarioGateway;
import com.jjimenez.jbalance.infrastructure.jpa.entity.SalarioEntity;
import com.jjimenez.jbalance.infrastructure.jpa.repository.SalarioRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SalarioJpaAdapter implements SalarioGateway {
    private final SalarioRepository salarioRepository;
    public SalarioJpaAdapter(SalarioRepository salarioRepository) {
        this.salarioRepository = salarioRepository;
    }

    @Override
    public Mono<Salario> buscarPorId(Long id) {
        return salarioRepository.findById(id)
                .flatMap(s -> {
                    Salario salario = entityToModel(s);
                    return Mono.just(salario);
                });
    }

    @Override
    public Mono<Salario> guardarSalario(Salario salario) {
        return Mono.just(salario)
                .flatMap(s -> {
                    SalarioEntity salarioEntity = modelToEntity(s);
                    return salarioRepository.save(salarioEntity);
                })
                .flatMap(s -> {
                    Salario salario1 = entityToModel(s);
                    return Mono.just(salario1);
                });
    }

    @Override
    public Flux<Salario> buscarTodosLosSalarios() {
        return salarioRepository.findAll().map(this::entityToModel);
    }

    @Override
    public Flux<Salario> buscarSalarioActivos() {
        return salarioRepository.findActivos().map(this::entityToModel);
    }

    private Salario entityToModel(SalarioEntity s) {
        Salario salario = new Salario();
        salario.setId(s.getId());
        salario.setConcepto(s.getConcepto());
        salario.setValor(s.getValor());
        salario.setEstado(s.getEstado());
        salario.setPeriodo(s.getPeriodo());
        salario.setSalarioExtra(s.getSalarioExtra());
        salario.setPrima(s.getPrima());
        return salario;
    }

    private SalarioEntity modelToEntity(Salario s) {
        SalarioEntity salarioEntity = new SalarioEntity();
        salarioEntity.setId(s.getId());
        salarioEntity.setConcepto(s.getConcepto());
        salarioEntity.setValor(s.getValor());
        salarioEntity.setEstado(s.getEstado());
        salarioEntity.setPeriodo(s.getPeriodo());
        salarioEntity.setSalarioExtra(s.getSalarioExtra());
        salarioEntity.setPrima(s.getPrima());
        return salarioEntity;
    }
}
