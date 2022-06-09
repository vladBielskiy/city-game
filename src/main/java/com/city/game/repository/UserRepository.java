package com.city.game.repository;

import com.city.game.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT COUNT(*) FROM game_user", nativeQuery = true)
    Integer getCountOfUsers();

    @Query(value = "SELECT * FROM game_user LIMIT 1", nativeQuery = true)
    User getCurrentUser();

    @Query(value = "SELECT * FROM game_user LIMIT 1", nativeQuery = true)
    Optional<User> findCurrentUser();

    void deleteAll();
}
