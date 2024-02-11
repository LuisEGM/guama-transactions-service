package com.guama.transactions.api.configuration;

import com.cloudogu.cb.CommandBus;
import com.cloudogu.cb.decorator.LoggingCommandBus;
import com.cloudogu.cb.spring.Registry;
import com.cloudogu.cb.spring.SpringCommandBus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Command bus configuration
 */
@Configuration
public class CommandBusConfiguration {

  /**
   * Command Bus bean declaration.
   *
   * @param applicationContext the application context
   * @return Command Bus
   */
  @Bean
  public CommandBus commandBus(ApplicationContext applicationContext) {
    return new LoggingCommandBus(new SpringCommandBus(new Registry(applicationContext)));
  }
}
