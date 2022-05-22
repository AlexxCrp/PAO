package com.example.PAO.profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository
        extends JpaRepository<Profesor, Long> {
    @Query("SELECT p FROM Profesor p WHERE p.email = ?1")
    Optional<Profesor> findProfesorByEmail(String email);
}
