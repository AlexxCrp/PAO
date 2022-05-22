package com.example.PAO.bursier;

import com.example.PAO.student.Student;

import javax.persistence.Entity;

@Entity
public class Bursier extends Student {
    private Integer valoareBursa;

    public Bursier() {
    }

    public Bursier(Integer valoareBursa) {
        this.valoareBursa = valoareBursa;
    }

    public Bursier(Long id, String nume, String prenume, String email, Integer an, Integer valoareBursa) {
        super(id, nume, prenume, email, an);
        this.valoareBursa = valoareBursa;
    }

    public Bursier(String nume, String prenume, String email, Integer an, Integer valoareBursa) {
        super(nume, prenume, email, an);
        this.valoareBursa = valoareBursa;
    }

    public Integer getValoareBursa() {
        return valoareBursa;
    }

    public void setValoareBursa(Integer valoareBursa) {
        this.valoareBursa = valoareBursa;
    }
}
