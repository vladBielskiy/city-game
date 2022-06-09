package com.city.game.repository;

import com.city.game.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "SELECT * FROM city ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    City getRandomCity();

    @Query(value = "SELECT * FROM city WHERE name LIKE ?1% ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    City getNextCity(String prefix);

}
