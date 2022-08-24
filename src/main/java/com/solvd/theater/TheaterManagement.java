/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 *
 * @author Erika92
 */
public class TheaterManagement {
    private ArrayList <Play> plays;
    private ArrayList <Theater> theaters;
    private Ticket ticket;

    //constructors
    public TheaterManagement() {
        this.ticket=new Ticket();
    }

    //Methods
    public void createTM(TheaterManagement tm){
        boolean exception;
        tm.createPlays(tm);
        
        do {
            exception=false;
            try {
                tm.selectPlay(tm);
            }catch (NotAValidPlayException|NotValidInputException e){
                exception=true; 
                System.out.println("Exception occurred. "+ e.getMessage());
            } 
        } while (exception);
        
        tm.createTheaters(tm);
        
        do {
            exception=false;
            try {
                tm.selectTheater(tm);
            }catch (NotAValidTheaterException|NotValidInputException e){
                exception=true; 
                System.out.println("Exception occurred. "+ e.getMessage());
            } 
        } while (exception);

        tm.checkAvailability(tm);
        
        tm.selectSeat(tm);   

        tm.printTicket(tm);

    }
    
    //Logger
    private static final Logger logger = LogManager.getLogger(TheaterManagement.class);
    
    public void createPlays(TheaterManagement tm){
        Play play=new Play();
        tm.setPlays(play.createList());
        tm.showPlays(play, tm);
    }
    
    public void showPlays(Play play, TheaterManagement tm){
        play.readList(tm.getPlays());
    }
    
    public void selectPlay(TheaterManagement tm) throws NotAValidPlayException,NotValidInputException{
        Scanner  sc=new Scanner(System.in);
        System.out.println("");
        System.out.println("Choose the show:");
        int option;
        if (sc.hasNextInt()) {
            option=sc.nextInt();
            if (option>tm.getPlays().size() || option<=0){
                sc.next();
                throw new NotAValidPlayException("The option selected is not valid Play. Please enter a valid option");
            }
            else {
                Play selectedPlay=tm.getPlays().get(option-1);
                tm.getTicket().setPlay(selectedPlay);
                System.out.println("You have selected "+tm.getTicket().getPlay().getShowName());
                System.out.println("");
            }            
        }else{
            sc.next();
            throw new NotValidInputException("That is not a valid input.");
            }
    }
 
    public void createTheaters(TheaterManagement tm){
        Theater t= new Theater();
        tm.setTheaters(t.createTheaters(tm));
        tm.showTheaters(t, tm);
        tm.createSeatsList(t);
    }
    
    public void showTheaters(Theater t, TheaterManagement tm){
        t.readTheaters(tm.getTheaters());
    }
    
    public void selectTheater (TheaterManagement tm)throws NotAValidTheaterException, NotValidInputException{
        Scanner sc=new Scanner(System.in);
        System.out.println("");
        System.out.println("Choose the theater:");
        int option;
        if (sc.hasNextInt()) {
            option=sc.nextInt();
            if (option>tm.getTheaters().size() || option<=0){
                sc.next();
                throw new NotAValidTheaterException("The option selected is not valid Theater. Please enter a valid option");
            }
            else {
                Theater selectedTheater=tm.getTheaters().get(option-1);
                Seats.createSeats(selectedTheater);
                tm.getTicket().setTheater(selectedTheater);
                System.out.println("You have selected "+tm.getTicket().getTheater().getTheaterName()+" Theater");
                System.out.println("");
                createSeatsList(selectedTheater);
                showSeatsList(selectedTheater);
                }
        }else   {
            sc.next();
            throw new NotValidInputException("That is not a valid input.");
        }


    } 

    
    public void createSeatsList(Theater t){
        Seats.createSeats(t); 
    }
    
    public void showSeatsList(Theater t){
        Seats.showSeatsList(t.getSeatList());
    }
   
    public void selectSeat(TheaterManagement tm){
        boolean exception;
        do {
            exception=false;
            try {
                Seats.selectSeat(tm);
            }catch (NotAvailableSeatException|NotValidInputException e){
                exception=true; 
                System.out.println("Exception occurred. "+ e.getMessage());
            } 
        } while (exception);
        System.out.println("");            
    }   
    
    public void checkAvailability(TheaterManagement tm){
        Theater t=new Theater();
        t.checkAvailability(tm.getTicket().getTheater().getSeatList());
    }


    public void printTicket(TheaterManagement tm){
        System.out.println("-------------------------------------------------");
        System.out.println("Your Ticket Number is "+Math.abs(tm.getTicket().hashCode())
        + "\n City: "+tm.getTicket().getTheater().getCITY()
        + "\n Theater: "+tm.getTicket().getTheater().getTheaterName()
        +"\n Show: "+tm.getTicket().getPlay().getShowName()
        +"\n Duration: "+tm.getTicket().getPlay().getDuration()
        +"\n Seat number: "+ tm.getTicket().getSeatNumber());
        System.out.println("");
    }

    //getters and setters


    public ArrayList<Play> getPlays() {
        return plays;
    }

    public void setPlays(ArrayList<Play> plays) {
        this.plays = plays;
    }

    public ArrayList<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(ArrayList<Theater> theaters) {
        this.theaters = theaters;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    //toString HashCode Equals
//    @Override
//    public String toString() {
//        System.out.println("---------------------------YOUR TICKET-----------------------------");
//        return "TheaterManagment{" + "theaterName=" + theater.getTheaterName()+ 
//                ", play=" + play.getPlayName() + ", duration(min)=" +
//                play.getDuration()+ ", seat="  + ", Ticket Number=" + 
//                +'}';
//    }

   
}
