package com.brilife.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIST_PEMAKAI_KONTRASEPSI")
public class Usage {
    @Id
    @GeneratedValue
    @Column(name = "Id_List")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "Id_Propinsi", nullable = false)
    private Province province;

    @ManyToOne
    @JoinColumn(name = "Id_Kontrasepsi", nullable = false)
    private Contraception contraception;

    @Column(name = "Jumlah_Pemakai", nullable = false)
    private Integer count;

    public Usage() {
    }

    public Usage(Province province, Contraception contraception, Integer count) {
        this.province = province;
        this.contraception = contraception;
        this.count = count;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Province getProvince() {
        return this.province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Contraception getContraception() {
        return this.contraception;
    }

    public void setContraception(Contraception contraception) {
        this.contraception = contraception;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}