package com.city.game.entity;

import javax.persistence.*;

@Entity
@Table(name = "game_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "score")
    private Integer score;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="last_city_id")
    private City lastCity;

    public User() {
    }

    public User(Integer id, Integer score, City lastCity) {
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

    public City getLastCity() {
        return lastCity;
    }

    public void setLastCity(City lastCity) {
        this.lastCity = lastCity;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
