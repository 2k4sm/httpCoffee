package com.sm2k4.httpcoffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm2k4.httpcoffee.model.Coffees;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffees,Long> {
    
}
