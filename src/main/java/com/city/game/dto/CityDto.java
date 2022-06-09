package com.city.game.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CityDto {

    @JsonIgnore
    private Integer id;

    private String name;

    public CityDto() {
    }

    public CityDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
