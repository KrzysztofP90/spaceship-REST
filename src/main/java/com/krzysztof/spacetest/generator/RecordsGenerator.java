package com.krzysztof.spacetest.generator;

import com.krzysztof.spacetest.SpaceTestApplication;
import com.krzysztof.spacetest.model.Country;
import com.krzysztof.spacetest.model.Gender;
import com.krzysztof.spacetest.model.Tourist;
import com.krzysztof.spacetest.repository.CountryRepository;
import com.krzysztof.spacetest.repository.FlightRepository;
import com.krzysztof.spacetest.repository.GenderRepository;
import com.krzysztof.spacetest.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RecordsGenerator implements CommandLineRunner {

    private SpaceTestApplication spaceTestApplication;
    private TouristRepository touristRepository;
    private FlightRepository flightRepository;
    private CountryRepository countryRepository;
    private GenderRepository genderRepository;

    Country pol = new Country();
    Country ger = new Country();
    Country fr = new Country();
    Gender male = new Gender();
    Gender female = new Gender();


    @Autowired
    public RecordsGenerator(SpaceTestApplication spaceTestApplication, FlightRepository flightRepository, TouristRepository touristRepository,
                            GenderRepository genderRepository, CountryRepository countryRepository) {
        this.spaceTestApplication = spaceTestApplication;
        this.touristRepository = touristRepository;
        this.flightRepository = flightRepository;
        this.genderRepository = genderRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeGender();
        initializeCountry();
//        initializeTourist();

    }

    private boolean initializeGender() {
        this.male.setGenderName("male");
        this.female.setGenderName("female");
        this.genderRepository.save(male);
        this.genderRepository.save(female);
        return true;
    }

    private boolean initializeCountry() {

        this.pol.setCountryName("Poland");
        this.ger.setCountryName("Germany");
        this.fr.setCountryName("France");
        this.countryRepository.save(this.pol);
        this.countryRepository.save((this.fr));
        this.countryRepository.save(this.ger);
        return true;
    }

//    private boolean initializeTourist() {
//        Tourist john = new Tourist();
//        john.setName("John");
//        john.setBithdayDate(new Date(321321312));
//        john.setCountry(this.fr);
//        john.setNotes("John is nervous");
//        john.setSex(this.male);
//        john.setSurname("Kennedy");
//        this.touristRepository.save(john);
//
//        Tourist caludia = new Tourist();
//        john.setName("Claudia");
//        john.setBithdayDate(new Date(31312));
//        john.setCountry(this.pol);
//        john.setNotes("Claudia is silent");
//        john.setSex(this.female);
//        john.setSurname("Shiffer");
//        this.touristRepository.save(caludia);
//
//        return true;
//    }
}
