package com.brilife.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIST_KONTRASEPSI")
public class Contraception {
    @Id
    @GeneratedValue
    @Column(name = "Id_Kontrasepsi")
    private Integer id;

    @Column(name = "Nama_Kontrasepsi", nullable = false)
    private String name;

    public Contraception() {
    }

    public Contraception(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}