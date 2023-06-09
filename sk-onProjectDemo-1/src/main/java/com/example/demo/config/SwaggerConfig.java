package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
*
* @author MW
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

   @Bean
   public Docket api() {
       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(getApiInfo())
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
               .paths(PathSelectors.any())
               .build();
   }

   private ApiInfo getApiInfo() {
       return new ApiInfoBuilder()
               .title("API")
               .description("[Bamdule] API")
               .contact(new Contact("Bamdule Swagger", "https://bamdule.tistory.com/", " "))
               .version("0.0.1")
               .build();
   }
}