package br.com.fatecararas.f290_ds2_book_api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.fatecararas.f290_ds2_book_api.api.v1.resource"))
                .paths(PathSelectors.any())                
                .build();                
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "DS2 Book API",
                "API de livros desenvida em Spring Boot",
                "v1",
                "http://www.termsofservice.com",
                contact(), "License of API",
                "Lincense URL",
                Collections.emptyList());
    }

    private Contact contact() {
        return new Contact("Esdras B Silva", "https://github.com/BZR4", "bzr4@icloud.com");
    }

}
