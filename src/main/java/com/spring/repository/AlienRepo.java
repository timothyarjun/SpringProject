package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Alien;


@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
