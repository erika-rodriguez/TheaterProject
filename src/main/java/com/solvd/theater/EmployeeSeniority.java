package com.solvd.theater;

public enum EmployeeSeniority {
    SENIOR ("Senior"),
    SEMISENIOR ("Semi-senior"),
    JUNIOR ("Junior"),
    TRAINEE("Trainee");

    //field
    String seniority;
    //constructor
    EmployeeSeniority (String seniority){
        this.seniority=seniority;
    }

    public String getSeniority(){
        return this.seniority;
    }
}
