package com.example.demo;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetteriesRepo extends JpaRepository<Betteries, Integer> {

    List<Betteries> findByPostCodeBetween(String startPostcode, String endPostcode);

}
