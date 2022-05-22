package com.example.PAO.profesor;

import com.example.PAO.materie.Materie;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Profesor {
    @Id
    @SequenceGenerator(
            name = "profesor_sequence",
            sequenceName = "profesor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profesor_sequence"
    )

    private Long id;
    private String nume;
    private String prenume;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "profesor")
    private Set<Materie> materii = new HashSet<>();

    public Profesor() {
    }

    public Profesor(Long id, String nume, String prenume, String email, Materie materiePredata) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
    }

    public Profesor(String nume, String prenume, String email, Materie materiePredata) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        materiePredata.setProfesor(this);
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Materie> getMaterii() {
        return materii;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
