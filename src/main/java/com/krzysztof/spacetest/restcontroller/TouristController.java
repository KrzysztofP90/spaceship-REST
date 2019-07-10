package com.krzysztof.spacetest.restcontroller;

import com.krzysztof.spacetest.model.Tourist;
import com.krzysztof.spacetest.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ver1/tourist")
public class TouristController {

    private TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public ResponseEntity<List<Tourist>> getAllTourists() {

        List<Tourist> tourists = this.touristService.getAllTourists();
        if (tourists.isEmpty()) {
            return new ResponseEntity<List<Tourist>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Tourist>>(tourists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addTourist(@RequestBody Tourist tourist) {
        this.touristService.addTourist(tourist);
        return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeTourist(@PathVariable("id") int id) {
        this.touristService.removeTourist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{touristId}/{flightId}")
    public ResponseEntity<?> addFlightToTourist(@PathVariable("flightId") int flightId, @PathVariable("touristId") int touristId ) {
        this.touristService.addFlightToTourist(flightId, touristId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{touristId}/{flightId}")
    public ResponseEntity<?> removeFlightFromTourist(@PathVariable("flightId") int flightId, @PathVariable("touristId") int touristId) {
        this.touristService.removeFlightFromTourist(flightId, touristId);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
