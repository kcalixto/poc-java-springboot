package com.kcalixto.pocspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kcalixto.pocspringboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
