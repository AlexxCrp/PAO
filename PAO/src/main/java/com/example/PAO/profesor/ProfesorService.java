package com.example.PAO.profesor;

import com.example.PAO.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfesorService {
    private final ProfesorRepository profesorRepository;
    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<Profesor> getProfesori() {
        return profesorRepository.findAll();
    }

    public void addProfesor(Profesor profesor) {
        Optional<Profesor> profesorByEmail = profesorRepository.
                findProfesorByEmail(profesor.getEmail());
        if(profesorByEmail.isPresent()){
            throw new IllegalStateException("Email deja asignat");
        }
        profesorRepository.save(profesor);
    }
    @Transactional
    public void updateProfesor(Long profesorId, String email, String nume, String prenume) {
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new IllegalStateException(
                        "nu exista id-ul " + profesorId
                ));

        if(email != null && email.length() > 0 &&
                !Objects.equals(profesor.getEmail(), email)) {
            Optional<Profesor> studentByEmail = profesorRepository.
                    findProfesorByEmail(email);
            if (studentByEmail.isPresent()) {
                throw new IllegalStateException("email deja asignat");
            }
            profesor.setEmail(email);
        }

        if(nume != null && nume.length() > 0 &&
                !Objects.equals(profesor.getNume(), nume)) {
            profesor.setNume(nume);
        }

        if(prenume != null && prenume.length() > 0 &&
                !Objects.equals(profesor.getPrenume(), prenume)) {
            profesor.setPrenume(prenume);
        }
    }

    public void deleteProfesor(Long profesorId) {
        if(!profesorRepository.existsById(profesorId))
        {
            throw new IllegalStateException(
                    "Nu exista student cu Id-ul " + profesorId);
        }
        profesorRepository.deleteById(profesorId);
    }
}
