package com.example.PAO.studemtAsmi;

import com.example.PAO.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentAsmiRepository
    extends JpaRepository<StudentAsmi, Long>{
    @Query("SELECT s FROM StudentAsmi s WHERE s.departament is not null ")
    Optional<StudentAsmi> findStudentAsmisByDepartamentExists();
}
