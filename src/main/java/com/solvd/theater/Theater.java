/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Erika92
 */
public class Theater {
    private int id;
    private String theaterName;
    private int capacity;
    private ArrayList<Seats> seatList;
    private final String CITY="New York";
    
    //constructors
    public Theater() {

    }

    public Theater(String theaterName, int capacity) {
        this.theaterName = theaterName;
        this.capacity = capacity;
    }
    
    public Theater(String theaterName, int capacity, ArrayList<Seats> seatList) {
        this.theaterName = theaterName;
        this.capacity = capacity;
        this.seatList = seatList;
    }

    public  ArrayList <Theater> createTheaters(TheaterManagement tm){
        Theater t1=new Theater("Radio City", 10);
        Theater t2=new Theater("Apollo", 20);
        Theater t3=new Theater("Majestic", 30);
        Theater t4=new Theater("Lincoln", 40);
        Theater t5=new Theater("Broadway", 15);

        ArrayList <Theater> theatersList=new ArrayList();
        theatersList.add(t1);
        theatersList.add(t2);
        theatersList.add(t3);
        theatersList.add(t4);
        theatersList.add(t5);
        return theatersList;
    }

    public ArrayList <Theater> deleteTheater(ArrayList <Theater> theatersList, int option){
        for (int i = 0; i < theatersList.size(); i++) {
            if (theatersList.get(i).getId()==option){
                theatersList.remove(i);
                break;
            }
        }
        return  theatersList;
    }
    
    public void readTheaters(ArrayList <Theater> theatersList){
        for (int i = 0; i < theatersList.size(); i++) {
            System.out.println((i+1)+". "+"["+theatersList.get(i).getTheaterName()+"] ");
        }
    }

    public void checkAvailability(ArrayList<Seats> seatsList){
        Seats.checkAvailability(seatsList);
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public ArrayList<Seats> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seats> seatList) {
        this.seatList = seatList;
    }

    public String getCITY() {
        return CITY;
    }
        
    //toString HashCode Equals
    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", theaterName='" + theaterName + '\'' +
                ", capacity=" + capacity +
                ", seatList=" + seatList +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theater)) return false;
        Theater theater = (Theater) o;
        return id == theater.id && capacity == theater.capacity && Objects.equals(theaterName, theater.theaterName) && Objects.equals(seatList, theater.seatList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theaterName, capacity, seatList);
    }
}
    
 
