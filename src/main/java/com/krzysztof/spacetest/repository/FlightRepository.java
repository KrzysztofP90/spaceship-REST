package com.krzysztof.spacetest.repository;

import com.krzysztof.spacetest.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Flight findById(int id);
}
