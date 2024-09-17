package com.is4tech.exercise.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    //Buscaremos al usuario por su username
    Optional<User> findByUsername(String username);
}
