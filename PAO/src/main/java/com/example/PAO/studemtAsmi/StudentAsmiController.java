package com.example.PAO.studemtAsmi;



import com.example.PAO.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/studentAsmi")
public class StudentAsmiController {
    private final StudentAsmiService studentAsmiService;

    @Autowired
    public StudentAsmiController(StudentAsmiService studentAsmiService) {
        this.studentAsmiService = studentAsmiService;
    }

    @GetMapping

    public List<StudentAsmi> getAsmiStudents() {
        Logging logger = new Logging();
        LocalDateTime timp = LocalDateTime.now();
        logger.writeStudentGet(timp, "GetASMI");
        return studentAsmiService.getAsmiStudents();
    }



}
