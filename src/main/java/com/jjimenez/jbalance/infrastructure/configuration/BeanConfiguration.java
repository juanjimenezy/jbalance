package com.jjimenez.jbalance.infrastructure.configuration;

import com.jjimenez.jbalance.application.usecase.GastoFijoUseCase;
import com.jjimenez.jbalance.application.usecase.MovimientoUseCase;
import com.jjimenez.jbalance.application.usecase.SalarioUseCase;
import com.jjimenez.jbalance.domain.model.gateways.GastoFijoGateway;
import com.jjimenez.jbalance.domain.model.gateways.MovimientoGateway;
import com.jjimenez.jbalance.domain.model.gateways.SalarioGateway;
import com.jjimenez.jbalance.infrastructure.jpa.adapter.GastoFijoJpaAdapter;
import com.jjimenez.jbalance.infrastructure.jpa.adapter.MovimientoJpaAdapter;
import com.jjimenez.jbalance.infrastructure.jpa.adapter.SalarioJpaAdapter;
import com.jjimenez.jbalance.infrastructure.jpa.repository.GastoFijoRepository;
import com.jjimenez.jbalance.infrastructure.jpa.repository.MovimientoRepository;
import com.jjimenez.jbalance.infrastructure.jpa.repository.SalarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public SalarioGateway salarioGateway(SalarioRepository salarioRepository) {
        return new SalarioJpaAdapter(salarioRepository);
    }

    @Bean
    public SalarioUseCase salarioUseCase(SalarioGateway salarioGateway) {
        return new SalarioUseCase(salarioGateway);
    }

    @Bean
    public GastoFijoGateway gastoFijoGateway(GastoFijoRepository gastoFijoRepository) {
        return new GastoFijoJpaAdapter(gastoFijoRepository);
    }

    @Bean
    public GastoFijoUseCase gastoFijoUseCase(GastoFijoGateway gastoFijoGateway) {
        return new GastoFijoUseCase(gastoFijoGateway);
    }

    @Bean
    public MovimientoGateway movimientoGateway(MovimientoRepository movimientoRepository) {
        return new MovimientoJpaAdapter(movimientoRepository);
    }

    @Bean
    public MovimientoUseCase movimientoUseCase(MovimientoGateway movimientoGateway,GastoFijoGateway gastoFijoGateway) {
        return new MovimientoUseCase(movimientoGateway, gastoFijoGateway);
    }

}
