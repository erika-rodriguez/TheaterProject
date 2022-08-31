package com.solvd.theater;

public enum UserMenu {
    A("1. Display available Theaters"),
    B("2. Search a Theater"),
    C("3. Display available Shows"),
    D("4. Search a Show"),
    E("5. Buy Ticket"),
    F("6. Exit");
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
