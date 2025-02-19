package com.hanturgaev.fitzal.repositories;

import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Найти пользователя по username


    // Найти пользователей по роли
    List<User> findByRole(UserRole role);

    // Найти пользователей с профилем клиента (clientProfile != null)
    List<User> findByClientProfileIsNotNull();

    public Optional<User> findByEmail(String email);
}