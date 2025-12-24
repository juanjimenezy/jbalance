package com.jjimenez.jbalance.infrastructure.configuration;

import com.jjimenez.jbalance.application.usecase.SalarioUseCase;
import com.jjimenez.jbalance.domain.model.gateways.SalarioGateway;
import com.jjimenez.jbalance.infrastructure.jpa.adapter.SalarioJpaAdapter;
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

}
