package com.example.PAO.bursier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BursierRepository extends JpaRepository<Bursier, Long> {
}
