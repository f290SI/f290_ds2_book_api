package br.com.fatecararas.f290_ds2_book_api.config;

import java.util.Collections;

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

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.fatecararas.f290_ds2_book_api.api.v1.resource"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("API Books Spring Boot")
                .description("API Para gerenciamento de livros e locação")
                .version("1.0")
                .contact(getContact())
                .build();
    }

    private Contact getContact() {
        //TODO: Utilize suas credenciais para criação do Contato.
        return new Contact("Esdras B Silva", "https://github.com/BZR4", "bzr4@icloud.com");
    }

}
