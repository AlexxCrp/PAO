package com.example.PAO.studemtAsmi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentAsmiConfig {
    @Bean
    CommandLineRunner commandLineRunner1(
            StudentAsmiRepository repository) {
        return args -> {
            StudentAsmi mircea = new StudentAsmi(
                    "Mircea",
                    "Carpineanu",
                    "mircea@gmail.com",
                    2,
                    "trezorerie"
            );

            StudentAsmi codrea = new StudentAsmi(
                    "Codrut",
                    "Bunghe",
                    "codrut@gmail.com",
                    1,
                    "HR"
            );

            repository.saveAll(
                    List.of(mircea, codrea)
            );
        };
    }
}
