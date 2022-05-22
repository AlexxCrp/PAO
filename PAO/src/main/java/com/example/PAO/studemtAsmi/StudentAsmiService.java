package com.example.PAO.studemtAsmi;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAsmiService {
    private final StudentAsmiRepository studentAsmiRepository;

    public StudentAsmiService(StudentAsmiRepository studentAsmiRepository) {
        this.studentAsmiRepository = studentAsmiRepository;
    }

    public List<StudentAsmi> getAsmiStudents() {
        return studentAsmiRepository.findAll();
    }
}

