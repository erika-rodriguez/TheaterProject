/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Erika92
 */
public class Customer implements IPerson, ILinkedList{
    private String customersName;
    private LocalDate dateOfBirth;//YYYY-MM-DD
    private int customerId;
    private String email;
    private String phoneNumber;
    private String category;//Kids, adult, senior
    private int age;
    private double ticketPrice;
    
    //constructor
    
    public Customer() {
    }

    public Customer(int id, String name, LocalDate dateOfBirth, String email, String phoneNumber) {
        createPerson(id,name, dateOfBirth, email, phoneNumber);
    }

    @Override
    public void createPerson(int id, String name, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.customerId=id;
        this.customersName=name;
        this.dateOfBirth=dateOfBirth;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
    
    //Getters from interface
    @Override
    public void setId(int id) {
        this.customerId = id;
        }
    @Override
    public void setName(String name) {
        this.customersName=name;
       }
    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
        }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //getters and setters
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getCustomersName() {
        return customersName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    
    
    
    //Methods from IPerson
    @Override
    public String calculateCategory(LocalDate dateOfBirth){
        LocalDate  today=java.time.LocalDate.now();
        if (dateOfBirth==null && today==null) {
            System.out.println("Please insert Customer's date of birth.");
        }else{
            setAge(Period.between(dateOfBirth, today).getYears());
            if (age>59) {
                category="Senior";
                setCategory(category);
                
            }else if (age>25) {
                category="Adult";
                setCategory(category);
            }else if (age>12) {
                category="Young";
                setCategory(category);
            }else{
                category="Kid";
                setCategory(category);
            }
        }
        return category;
     }
   //The benefit is a discount on Ticket price
    @Override
     public double calculateBenefits(String category)throws NotValidCategoryException{
         double ticketPrice=100;
         if (category.equalsIgnoreCase("kid")) {
              //System.out.println("Kids get 50% discount.");
              ticketPrice=0.5*ticketPrice;
              //Ticket.set.ticketPrice
        }else if (category.equalsIgnoreCase("young")) {
              //System.out.println("Youngs get 20% discount.");
              ticketPrice=0.8*ticketPrice;
            //Ticket.set.ticketPrice
        }else if (category.equalsIgnoreCase("adult")) {
              //System.out.println("Adults do not have discount.");
            //Ticket.set.ticketPrice
        }else if (category.equalsIgnoreCase("senior")){
              //System.out.println("Seniors get 50% discount.");
              ticketPrice=0.5*ticketPrice;
              //Ticket.set.ticketPrice
        }else{
            throw new NotValidCategoryException ("Please enter a valid Customer's category.");
        }
         return ticketPrice;
    }
     
    //Methods from ILinkedList
    @Override
    public CustomLinkedList createLinkedList(){
        System.out.println("==============Loading customers======================");
        
        Customer c1=new Customer(01, "Kate Johnson", LocalDate.parse("1950-12-10"), "kjohnson@mail.com", "1145472");
        c1.setCategory(c1.calculateCategory(c1.getDateOfBirth()));
        
        Customer c2=new Customer(02, "James Williams", LocalDate.parse("1967-07-06"), "jwilliams@mail.com", "1145811");
        c2.setCategory(c2.calculateCategory(c2.getDateOfBirth()));
        
        Customer c3=new Customer(02, "Kim Bown", LocalDate.parse("1996-08-26"), "kbrown@mail.com", "114959");
        c3.setCategory(c3.calculateCategory(c3.getDateOfBirth()));
        
        Customer c4=new Customer(02, "Cole Miller", LocalDate.parse("2021-12-07"), "cmiller@mail.com", "114959");
        c4.setCategory(c4.calculateCategory(c4.getDateOfBirth()));
        try{
            c1.setTicketPrice(c1.calculateBenefits(c1.getCategory()));
            c2.setTicketPrice(c2.calculateBenefits(c2.getCategory()));
            c3.setTicketPrice(c3.calculateBenefits(c3.getCategory()));
            c4.setTicketPrice(c4.calculateBenefits(c4.getCategory()));
        }catch (NotValidCategoryException e) {
            System.out.println("Exception."+e.getMessage());
        }

        CustomLinkedList<Customer> customerList=new CustomLinkedList<>();
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
        customerList.add(c4); 
        
        return customerList;
    }
    
    @Override
    public void showLinkedList(CustomLinkedList customerList){
        System.out.println(customerList.toString());
    }
    @Override
    public void modifyLinkedList(CustomLinkedList customerList, Object newElement){
        Scanner sc=new Scanner(System.in);
        System.out.println("Insert position of new element:");
        try{        
            int position=sc.nextInt();
            customerList.add(position, newElement);
            System.out.println(customerList.toString());
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds Exception.");
        }
    }
    
    //toString
    
    @Override
    public String toString() {
        
        return "Customer{" + ", customerId=" + customerId 
                +"customersName=" + customersName 
                + "\n dateOfBirth=" + dateOfBirth 
                + "\n email=" + email 
                + "\n phoneNumber=" + phoneNumber 
                + "\n category=" + category 
                + "\n age=" + age 
                + "\n ticketPrice="+ticketPrice+'}'+"\n"+"\n";
    }


}
