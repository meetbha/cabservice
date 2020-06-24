package com.cabservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabservice.model.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {

	boolean existsByLocation(String pickUpLocation);

	List<Cab> findAllByLocation(String pickUpLocation);

}
