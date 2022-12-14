package es.gusguma.kafkademo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static java.util.Objects.nonNull;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Configuration
public class LoggerConfig {

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public Logger logger(final InjectionPoint injectionPoint) {
        final Logger logger;
        if (nonNull(injectionPoint)) {
            logger = LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
        } else {
            logger = LoggerFactory.getLogger(this.getClass());
        }
        return logger;
    }
}
