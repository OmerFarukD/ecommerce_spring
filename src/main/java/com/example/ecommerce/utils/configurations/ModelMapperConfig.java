package com.example.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;            // Spring Config
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;         // ModelMapper’ın AccessLevel’i
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        // Genel eşleme ayarları
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setMethodAccessLevel(AccessLevel.PUBLIC)
                .setSourceNamingConvention(NamingConventions.NONE)
                .setDestinationNamingConvention(NamingConventions.NONE)
                .setImplicitMappingEnabled(true);

        // Record desteğini ekleyin
        mapper.registerModule(new org.modelmapper.record.RecordModule());
        return mapper;
    }
}
