package com.krzysztof.spacetest.restcontroller;

import com.krzysztof.spacetest.model.Flight;
import com.krzysztof.spacetest.model.Tourist;
import com.krzysztof.spacetest.repository.TouristRepository;
import com.krzysztof.spacetest.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ver1/flight")
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = this.flightService.getAllFlights();
        if (flights.isEmpty()) {
            return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
        this.flightService.addFlight(flight);
        return new ResponseEntity<Flight>(flight, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeFlight(@PathVariable("id") int id) {
        this.flightService.removeFlight(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{flightId}/{touristId}")
    public ResponseEntity<?> addTouristToFlight(@PathVariable("touristId") int touristId, @PathVariable("flightId") int flightId) {
        this.flightService.addTouristToFlight(touristId,flightId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{flightId}/{touristId}")
    public ResponseEntity<?> removeTouristFromFlight(@PathVariable("touristId") int touristId, @PathVariable("flightId") int flightId) {
        this.flightService.removeTouristFromFlight(touristId, flightId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
