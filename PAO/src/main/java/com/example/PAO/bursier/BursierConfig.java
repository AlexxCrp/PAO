package com.example.PAO.bursier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BursierConfig {
    @Bean
    CommandLineRunner commandLineRunner2(
            BursierRepository repository){
        return args -> {
            Bursier bianca = new Bursier(
                    "Bianca",
                    "Cucurizeanu",
                    "bianca@email.com",
                    3,
                    400
            );
            repository.saveAll(List.of(bianca));
        };
    }
}
