package com.sm2k4.httpcoffee.Coffees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffees,Long> {
    
}
