package com.hubertdostal.tmobile.homework.repository;

import com.hubertdostal.tmobile.homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
