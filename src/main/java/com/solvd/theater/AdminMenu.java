package com.solvd.theater;

public enum AdminMenu {
    A("1. Display Employee's List"),
    B("2. Insert new Employee to the List"),
    C("3. Display Customer's List"),
    D("4. Insert new Customer to the List"),
    E("5. Exit");
    //field
    String option;
    //constructor
    AdminMenu (String option){
        this.option=option;
    }

    public String getOption(){
        return this.option;
    }
}
