package com.example.PAO.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.
                findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email deja asignat");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId))
        {
            throw new IllegalStateException(
                    "Nu exista student cu Id-ul " + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String email,
                              String nume,
                              String prenume) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "nu exista id-ul " + studentId
                ));

        if(email != null && email.length() > 0 &&
        !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentByEmail = studentRepository.
                    findStudentByEmail(email);
            if (studentByEmail.isPresent()) {
                throw new IllegalStateException("email deja asignat");
            }
            student.setEmail(email);
        }

        if(nume != null && nume.length() > 0 &&
                !Objects.equals(student.getNume(), nume)) {
            student.setNume(nume);
        }

        if(prenume != null && prenume.length() > 0 &&
                !Objects.equals(student.getPrenume(), prenume)) {
            student.setPrenume(prenume);
        }


    }
}


