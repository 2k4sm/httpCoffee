package com.sm2k4.httpcoffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm2k4.httpcoffee.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    
}
