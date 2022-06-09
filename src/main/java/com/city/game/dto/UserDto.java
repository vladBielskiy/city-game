package com.city.game.dto;

public class UserDto {

    private Integer id;

    private Integer score;

    private CityDto lastCity;

    public UserDto() {
    }

    public UserDto(Integer id, Integer score, CityDto lastCity) {
        this.id = id;
        this.score = score;
        this.lastCity = lastCity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CityDto getLastCity() {
        return lastCity;
    }

    public void setLastCity(CityDto lastCity) {
        this.lastCity = lastCity;
    }

    public Integer getScore() { return score; }

    public void setScore(Integer score) {
        this.score = score;
    }
}
