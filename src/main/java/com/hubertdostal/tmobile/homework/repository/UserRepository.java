package com.hubertdostal.tmobile.homework.repository;

import com.hubertdostal.tmobile.homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
