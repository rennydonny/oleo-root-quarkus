package oleo.root.quarkus.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import oleo.root.quarkus.domain.port.in.GreetingUseCase;
import oleo.root.quarkus.domain.port.out.EventPublisher;
import oleo.root.quarkus.domain.service.GreetingService;

/**
 * Productor de beans de dominio para la inyección de dependencias de Quarkus.
 * Mantiene el dominio 100% agnóstico de Quarkus.
 */
@ApplicationScoped
public class DomainConfig {

    /**
     * Produce la instancia del servicio de dominio.
     * @param eventPublisher Publicador de eventos.
     * @return Implementación del caso de uso.
     */
    @Produces
    @ApplicationScoped
    public GreetingUseCase greetingUseCase(EventPublisher eventPublisher) {
        return new GreetingService(eventPublisher);
    }
}
