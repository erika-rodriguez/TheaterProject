/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import java.util.Objects;

/**
 *
 * @author Erika92
 */
public class Ticket {
    private int ticketNumber;
    private int seatNumber;
    private double price;
    private Play play;
    private Theater theater;

    //constructor
    public Ticket() {
    }

    public Ticket(int ticketNumber, int seatNumber,double price, Play play, Theater theater) {
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.price=price;
        this.play = play;
        this.theater = theater;
    }
    //getters and setters
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {    
        this.price = price;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Play getPlay() {
        return play;
    }
    public void setPlay(Play play) {
        this.play = play;
    }

    public Theater getTheater() {
        return theater;
    }
    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketNumber=" + ticketNumber + ", seatNumber=" + seatNumber + ", play=" + play + ", theater=" + theater + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.ticketNumber;
        hash = 79 * hash + this.seatNumber;
        hash = 79 * hash + Objects.hashCode(this.play);
        hash = 79 * hash + Objects.hashCode(this.theater);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.ticketNumber != other.ticketNumber) {
            return false;
        }
        if (this.seatNumber != other.seatNumber) {
            return false;
        }
        if (!Objects.equals(this.play, other.play)) {
            return false;
        }
        if (!Objects.equals(this.theater, other.theater)) {
            return false;
        }
        return true;
    }

    
    
}
