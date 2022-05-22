package com.example.PAO.student;

import com.example.PAO.materie.Materie;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    protected Long id;
    protected String nume;
    protected String prenume;

    protected String email;
    protected Integer an;

    @JsonIgnore
    @ManyToMany(mappedBy = "studentiInscrisi")
    protected Set<Materie> materii = new HashSet<>();

    public Student() {
    }

    public Student(Long id,
                   String nume,
                   String prenume,
                   String email,
                   Integer an) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.an = an;
    }

    public Student(String nume,
                   String prenume,
                   String email,
                   Integer an) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.an = an;
    }

    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAn() {
        return an;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public Set<Materie> getMaterii() {
        return materii;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", an=" + an +
                '}';
    }
}
