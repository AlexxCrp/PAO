package com.example.PAO.materie;

import com.example.PAO.profesor.Profesor;
import com.example.PAO.profesor.ProfesorRepository;
import com.example.PAO.student.Student;
import com.example.PAO.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MaterieService {
    private final MaterieRepository materieRepository;
    private final ProfesorRepository profesorRepository;
    private final StudentRepository studentRepository;

//    @Autowired
//    public MaterieService(MaterieRepository materieRepository) {
//        this.materieRepository = materieRepository;
//    }
//
//    @Autowired
//    public MaterieService(ProfesorRepository profesorRepository) {
//        this.profesorRepository = profesorRepository;
//    }

    @Autowired
    public MaterieService(MaterieRepository materieRepository, ProfesorRepository profesorRepository, StudentRepository studentRepository) {
        this.materieRepository = materieRepository;
        this.profesorRepository = profesorRepository;
        this.studentRepository = studentRepository;
    }

    public List<Materie> getMaterii() {
        return materieRepository.findAll();
    }

    public void addNewMaterie(Materie materie) {
        Optional<Materie> materieByNume = materieRepository.findMaterieByNume(materie.getNume());
        if (materieByNume.isPresent()){
            throw new IllegalStateException("Materia exista deja");
        }
        materieRepository.save(materie);
    }

    public void deleteMaterie(Long materieId) {
        if(!materieRepository.existsById(materieId)){
            throw new IllegalStateException(
                    "Nu exista materie cu Id-ul " + materieId
            );
        }
        materieRepository.deleteById(materieId);
    }

    @Transactional
    public void updateMaterie(Long materieId, String nume, Integer nrCredite) {
        Materie materie = materieRepository.findById(materieId).orElseThrow(
                () -> new IllegalStateException("Nu exista id-ul " + materieId));

        if(nume != null && nume.length() > 0 &&
                !Objects.equals(materie.getNume(), nume)) {
            Optional<Materie> materieByNume = materieRepository.
                    findMaterieByNume(nume);
            if (materieByNume.isPresent()) {
                throw new IllegalStateException("materie deja adaugata");
            }
            materie.setNume(nume);
        }

        if(nrCredite != null && !Objects.equals(materie.getNrCredite(), nrCredite)) {
            materie.setNrCredite(nrCredite);
        }
    }

    public void adaugaProfLaMaterie(Long materieId, Long profesorId) {
        Materie materie = materieRepository.findById(materieId).get();
        Profesor profesor = profesorRepository.findById(profesorId).get();

        materie.adaugaProf(profesor);
        materieRepository.save(materie);
    }

    public void adaugaStudentLaMaterie(Long materieId, Long studentId) {
        Materie materie = materieRepository.findById(materieId).get();
        Student student = studentRepository.findById(studentId).get();

        materie.adaugaStudent(student);
        materieRepository.save(materie);
    }

    public List<Materie> getMateriiOrderedByNrCredite() {
       return materieRepository.findAllByOrderByNrCrediteAsc();
    }
}
