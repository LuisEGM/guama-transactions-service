package com.guama.transactions.api.configuration;

import com.guama.transactions.GuamaTransactionsServiceApplication;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration
 */
@Configuration
@ComponentScan(basePackageClasses = {GuamaTransactionsServiceApplication.class})
public class SwaggerConfiguration {
  private final String applicationName;
  private static final String DESCRIPTION = "This is the guama transactions service API";

  /**
   * Constructor
   *
   * @param applicationName The application name
   */
  public SwaggerConfiguration(
    @Value("${spring.application.name}") String applicationName) {
    this.applicationName = applicationName;
  }

  /**
   * Api info.
   *
   * @return ApiInfo
   */
  @Bean
  public OpenAPI apiInfo() {
    return new OpenAPI()
      .info(new Info().title(applicationName)
        .description(DESCRIPTION)
        .version("v1.0.0")
        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
      .externalDocs(new ExternalDocumentation()
        .description("Springdoc OpenAPI 3")
        .url("https://springdoc.org/"));
  }
}
