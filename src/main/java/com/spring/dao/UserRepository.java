package com.spring.dao;

import com.spring.dao.model.User;
import com.spring.dao.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    List<User> findByUserRole(UserRole userRole);
}
