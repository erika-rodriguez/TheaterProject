package com.solvd.theater;

public enum UserMenu {
    A("1. Display available Theaters"),
    B("2. Display available Shows"),
    C("3. Buy Ticket"),
    D("4. Exit");
    //field
    String option;
    //constructor
    UserMenu (String option){
        this.option=option;
    }

    public String getOption(){
        return this.option;
    }
}
