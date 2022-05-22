package com.example.PAO.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student alex = new Student(
                    "Alex",
                    "Carpineanu",
                    "alex@gmail.com",
                    2
            );

            Student mita = new Student(
                    "Mita",
                    "Bunghe",
                    "mita@gmail.com",
                    1
            );

            repository.saveAll(
                    List.of(alex, mita)
            );
        };
    }
}
