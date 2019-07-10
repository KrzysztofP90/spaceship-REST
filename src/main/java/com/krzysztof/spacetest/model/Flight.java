package com.krzysztof.spacetest.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

    @Column(name = "arrival_date", nullable = false)
    private Date arrivalDate;

    @Column(name = "seats_count", nullable = false)
    private short countOfSeats;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "tourist_flight",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "tourist_id"))
    private Set<Tourist> tourists;

    @Column(name = "ticket_price", nullable = false)
    private BigDecimal ticketPrice;

    public Flight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public short getCountOfSeats() {
        return countOfSeats;
    }

    public void setCountOfSeats(short countOfSeats) {
        this.countOfSeats = countOfSeats;
    }

    public Set<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(Set<Tourist> tourists) {
        this.tourists = tourists;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
