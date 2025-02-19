package com.hanturgaev.fitzal.repositories;

import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Найти пользователя по email
    User findByEmail(String email);

    // Найти пользователей по роли
    List<User> findByRole(UserRole role);

    // Найти пользователей с профилем тренера (trainerProfile != null)
    List<User> findByTrainerProfileIsNotNull();

    // Найти пользователей с профилем клиента (clientProfile != null)
    List<User> findByClientProfileIsNotNull();
}