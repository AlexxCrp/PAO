package com.example.PAO.materie;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterieRepository
    extends JpaRepository<Materie, Long> {
    Optional<Materie> findMaterieByNume(String nume);

    @Query("SELECT m from Materie m ORDER BY m.nrCredite")
    List<Materie> findAllByOrderByNrCrediteAsc();
}
