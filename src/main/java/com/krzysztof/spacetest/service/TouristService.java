package com.krzysztof.spacetest.service;

import com.krzysztof.spacetest.model.Flight;
import com.krzysztof.spacetest.model.Tourist;
import com.krzysztof.spacetest.repository.FlightRepository;
import com.krzysztof.spacetest.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TouristService {

    private TouristRepository touristRepository;
    private FlightRepository flightRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository, FlightRepository flightRepository) {
        this.touristRepository = touristRepository;
        this.flightRepository = flightRepository;
    }

    public List<Tourist> getAllTourists() {
        return this.touristRepository.findAll();
    }

    public Tourist addTourist(Tourist tourist) {
        return this.touristRepository.save(tourist);
    }

    public void removeTourist(int id) {
        Tourist touristToRemove = this.touristRepository.findById(id);
        touristRepository.delete(touristToRemove);
    }



    public Tourist addFlightToTourist(int flightId, int touristId) {
        Flight flightToAdd = this.flightRepository.findById(flightId);
        Tourist touristToUpdate = this.touristRepository.findById(touristId);
        Set<Flight> flightsList = touristToUpdate.getFlights();
        flightsList.add(flightToAdd);
        touristToUpdate.setFlights(flightsList);
        return this.touristRepository.save(touristToUpdate);
    }

    public Tourist removeFlightFromTourist(int flightId, int touristId) {
        Flight flightToRemove = this.flightRepository.findById(flightId);
        Tourist touristToUpdate = this.touristRepository.findById(touristId);
        Set<Flight> flightSet = touristToUpdate.getFlights();
        flightSet.remove(flightToRemove);
        touristToUpdate.setFlights(flightSet);
        return this.touristRepository.save(touristToUpdate);
    }

}
