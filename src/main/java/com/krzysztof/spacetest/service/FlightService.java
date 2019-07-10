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
public class FlightService {


    private FlightRepository flightRepository;
    private TouristRepository touristRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, TouristRepository touristRepository) {
        this.flightRepository = flightRepository;
        this.touristRepository = touristRepository;
    }

    public List<Flight> getAllFlights() {
        return this.flightRepository.findAll();
    }

    public Flight addFlight(Flight flight) {
        return this.flightRepository.save(flight);
    }

    public void removeFlight(int id) {
        Flight flight = this.flightRepository.findById(id);
        this.flightRepository.delete(flight);
    }

    public Flight addTouristToFlight(int touristId,int flightId) {
        Flight flightToUpdate = this.flightRepository.findById(flightId);
        Tourist touristToAdd = this.touristRepository.findById(touristId);
        Set<Tourist> touristSet = flightToUpdate.getTourists();
        touristSet.add(touristToAdd);
        flightToUpdate.setTourists(touristSet);
        return this.flightRepository.save(flightToUpdate);
    }

    public Flight removeTouristFromFlight(int touristId,int flightId) {
        Flight flightToUpdate = this.flightRepository.findById(flightId);
        Tourist touristToRemove = this.touristRepository.findById(touristId);
        Set<Tourist> touristSet = flightToUpdate.getTourists();
        touristSet.remove(touristToRemove);
        flightToUpdate.setTourists(touristSet);
        return this.flightRepository.save(flightToUpdate);
    }

    public int getOcuppiedSeatsFromFlyById(int flightId) {
        Flight flight = this.flightRepository.findById(flightId);
        return (short) flight.getTourists().size();
    }

    public int getFreeSeatsFromFligtById(int flightId) {
        Flight flight = this.flightRepository.findById(flightId);
        short occupiedSeats = (short) flight.getTourists().size();
        return flight.getCountOfSeats() - occupiedSeats;
    }

}
