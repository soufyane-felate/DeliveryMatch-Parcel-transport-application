package com.DeliveryMatch.DeliveryMatch.repository;


import com.DeliveryMatch.DeliveryMatch.entities.User;
import com.DeliveryMatch.DeliveryMatch.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)")
    Optional<User> findFirstByEmail(@Param("email") String email);
    Optional<User> findByUserRole(UserRole userRole);
}