package com.guama.transactions.api.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Model mapper configuration
 */
@Configuration
public class ModelMapperConfiguration {

  /**
   * ModelMapper bean declaration.
   *
   * @return ModelMapper Bean
   */
  @Bean
  public ModelMapper modelMapper() {
    var modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setAmbiguityIgnored(true);
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    return modelMapper;
  }
}
