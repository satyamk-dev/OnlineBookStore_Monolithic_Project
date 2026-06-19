package com.nareshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.entity.Ratings;

public interface RatingsRepo extends JpaRepository<Ratings, Long>{

}
