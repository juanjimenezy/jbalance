package com.jjimenez.jbalance.infrastructure.jpa.adapter;

import com.jjimenez.jbalance.domain.model.GastoFijo;
import com.jjimenez.jbalance.domain.model.gateways.GastoFijoGateway;
import com.jjimenez.jbalance.infrastructure.jpa.entity.GastoFijoEntity;
import com.jjimenez.jbalance.infrastructure.jpa.repository.GastoFijoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GastoFijoJpaAdapter implements GastoFijoGateway {
    private final GastoFijoRepository gastoFijoRepository;
    public GastoFijoJpaAdapter(GastoFijoRepository gastoFijoRepository) {
        this.gastoFijoRepository = gastoFijoRepository;
    }

    @Override
    public Mono<GastoFijo> buscarPorId(Long id) {
        return gastoFijoRepository.findById(id)
                .flatMap(g -> {
                    GastoFijo gastoFijo = entityToModel(g);
                    return Mono.just(gastoFijo);
                });
    }

    @Override
    public Mono<GastoFijo> guardarGastoFijo(GastoFijo gastoFijo) {
        return Mono.just(gastoFijo)
                .flatMap(g -> {
                    GastoFijoEntity gastoFijoEntity = modelToEntity(g);
                    return gastoFijoRepository.save(gastoFijoEntity);
                })
                .flatMap(g -> {
                    GastoFijo gastoFijo1 = entityToModel(g);
                    return Mono.just(gastoFijo1);
                });
    }

    @Override
    public Flux<GastoFijo> buscarTodosLosGastosFijos() {
        return gastoFijoRepository.findActivos().map(this::entityToModel);
    }

    @Override
    public Flux<GastoFijo> buscarGastosFijosPorPagarSegunPeriodo(String periodo) {
        return gastoFijoRepository.findPorPagarByPeriodo(periodo)
                .map(this::entityToModel);
    }

    private GastoFijo entityToModel(GastoFijoEntity gastoFijoEntity) {
        GastoFijo gastoFijo = new GastoFijo();
        gastoFijo.setId(gastoFijoEntity.getId());
        gastoFijo.setConcepto(gastoFijoEntity.getConcepto());
        gastoFijo.setValor(gastoFijoEntity.getValor());
        gastoFijo.setEstado(gastoFijoEntity.getEstado());
        gastoFijo.setPeriodo(gastoFijoEntity.getPeriodo());
        return gastoFijo;
    }

    private GastoFijoEntity modelToEntity(GastoFijo gastoFijo) {
        GastoFijoEntity gastoFijoEntity = new GastoFijoEntity();
        gastoFijoEntity.setId(gastoFijo.getId());
        gastoFijoEntity.setConcepto(gastoFijo.getConcepto());
        gastoFijoEntity.setValor(gastoFijo.getValor());
        gastoFijoEntity.setEstado(gastoFijo.getEstado());
        gastoFijoEntity.setPeriodo(gastoFijo.getPeriodo());
        return gastoFijoEntity;
    }

}
