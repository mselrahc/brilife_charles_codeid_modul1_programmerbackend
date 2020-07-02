package com.brilife.backend.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class UsageModel {
    private Integer id;
    
    @NotNull
    private ProvinceModel province;
    
    @NotNull
    private ContraceptionModel contraception;

    @NotNull
    @PositiveOrZero
    private Integer count;

    public UsageModel() {
    }

    public UsageModel(ProvinceModel province, ContraceptionModel contraception, Integer count) {
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

    public ProvinceModel getProvince() {
        return this.province;
    }

    public void setProvince(ProvinceModel province) {
        this.province = province;
    }

    public ContraceptionModel getContraception() {
        return this.contraception;
    }

    public void setContraception(ContraceptionModel contraception) {
        this.contraception = contraception;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}