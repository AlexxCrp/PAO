package com.example.PAO.studemtAsmi;

import com.example.PAO.student.Student;

import javax.persistence.*;

@Entity

public class StudentAsmi extends Student {
    private String departament;

    public StudentAsmi() {
    }

    public StudentAsmi(String departament) {
        this.departament = departament;
    }

    public StudentAsmi(Long id, String nume, String prenume, String email, Integer an, String departament) {
        super(id, nume, prenume, email, an);
        this.departament = departament;
    }

    public StudentAsmi(String nume, String prenume, String email, Integer an, String departament) {
        super(nume, prenume, email, an);
        this.departament = departament;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
}
