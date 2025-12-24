package com.jjimenez.jbalance.infrastructure.jpa.adapter;

import com.jjimenez.jbalance.domain.model.Movimiento;
import com.jjimenez.jbalance.domain.model.gateways.MovimientoGateway;
import com.jjimenez.jbalance.infrastructure.jpa.entity.MovimientoEntity;
import com.jjimenez.jbalance.infrastructure.jpa.repository.MovimientoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MovimientoJpaAdapter implements MovimientoGateway {
    private final MovimientoRepository movimientoRepository;
    public MovimientoJpaAdapter(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public Mono<Movimiento> buscarPorId(Long id) {
        return movimientoRepository.findById(id)
                .map(this::entityToModel);
    }

    @Override
    public Mono<Movimiento> guardarMovimiento(Movimiento movimiento) {
        return Mono.just(movimiento)
                .flatMap(m -> {
                    MovimientoEntity movimientoEntity = modelToEntity(m);
                    return movimientoRepository.save(movimientoEntity);
                })
                .flatMap(m -> {
                    Movimiento movimiento1 = entityToModel(m);
                    return Mono.just(movimiento1);
                });
    }

    @Override
    public Flux<Movimiento> buscarPorPeriodo(String periodo) {
        return movimientoRepository.findByPeriodo(periodo)
                .map(this::entityToModel);
    }

    private MovimientoEntity modelToEntity(Movimiento movimiento) {
        MovimientoEntity movimientoEntity = new MovimientoEntity();
        movimientoEntity.setId(movimiento.getId());
        movimientoEntity.setIdGastoFijo(movimiento.getIdGastoFijo());
        movimientoEntity.setValor(movimiento.getValor());
        movimientoEntity.setFecha(movimiento.getFecha());
        movimientoEntity.setDescripcion(movimiento.getDescripcion());
        return movimientoEntity;
    }

    private Movimiento entityToModel(MovimientoEntity movimiento) {
        Movimiento movimientoM = new Movimiento();
        movimientoM.setId(movimiento.getId());
        movimientoM.setIdGastoFijo(movimiento.getIdGastoFijo());
        movimientoM.setValor(movimiento.getValor());
        movimientoM.setFecha(movimiento.getFecha());
        movimientoM.setDescripcion(movimiento.getDescripcion());
        movimientoM.setPeriodo(movimiento.getPeriodo());
        return movimientoM;
    }
}
