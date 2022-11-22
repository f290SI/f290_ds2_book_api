package br.com.fatecararas.f290_ds2_book_api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
