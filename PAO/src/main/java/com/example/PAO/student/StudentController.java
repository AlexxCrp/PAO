package com.example.PAO.student;

import com.example.PAO.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {



    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "GetAllStudents");
        return studentService.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "addStudent");
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "DeleteStudent");
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) String nume,
                              @RequestParam(required = false) String prenume) {
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "UpdateStudent");
        studentService.updateStudent(studentId, email, nume, prenume);
    }
}
