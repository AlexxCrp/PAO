package com.example.PAO.materie;

import com.example.PAO.profesor.Profesor;
import com.example.PAO.student.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Materie {
    @Id
    @SequenceGenerator(
            name = "materie_sequence",
            sequenceName = "materie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "materie_sequence"
    )
    private Long id;
    private String nume;
    private Integer nrCredite;

    @ManyToMany
    @JoinTable(
            name = "catalog",
            joinColumns = @JoinColumn(name = "materie_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> studentiInscrisi = new HashSet<>();



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profesor_id", referencedColumnName = "id")
    private Profesor profesor;
//    @OneToMany
//    private List<Tutor> tutori;
    public Materie() {
    }

    public Materie(Long id, String nume, Integer nrCredite) {
        this.id = id;
        this.nume = nume;
        this.nrCredite = nrCredite;
    }

    public Materie(String nume, Integer nrCredite) {
        this.nume = nume;
        this.nrCredite = nrCredite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getNrCredite() {
        return nrCredite;
    }

    public void setNrCredite(Integer nrCredite) {
        this.nrCredite = nrCredite;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    @Override
    public String toString() {
        return "Materie{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", nrCredite=" + nrCredite +
                '}';
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void adaugaProf(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Student> getStudentiInscrisi() {
        return studentiInscrisi;
    }

    public void adaugaStudent(Student student) {
        this.studentiInscrisi.add(student);
    }


//    public void setTutor(Tutor tutor) {
//        this.tutori.add(tutor);
//    }
}
