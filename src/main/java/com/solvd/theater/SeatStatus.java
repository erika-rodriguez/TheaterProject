package com.solvd.theater;

public enum SeatStatus {
    AVAILABLE ("Available"),
    OCCUPIED ("Occupied");
    //field
    String status;
    //constructor
    SeatStatus (String status){
        this.status=status;
    }

    public String getStatus(){
        return this.status;
    }
}
