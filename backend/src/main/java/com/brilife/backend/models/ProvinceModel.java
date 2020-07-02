package com.brilife.backend.models;

import javax.validation.constraints.NotBlank;

public class ProvinceModel {
    private Integer id;
    
    @NotBlank
    private String name;

    public ProvinceModel() {
    }

    public ProvinceModel(Integer id, String name) {
        this.id = id;
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