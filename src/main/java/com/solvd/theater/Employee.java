/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;


import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
/**
 *
 * @author Erika92
 */
public class Employee implements IPerson,ILinkedList {
    private int employeeId;
    private String employeeName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    
    private LocalDate jobStartDate;
    private double salary;
    private String category;

    public Employee() {
    }
    
    public Employee(int id, String name, LocalDate dateOfBirth, String email, String phoneNumber, LocalDate jobStartDate) {
        createPerson(id,name, dateOfBirth, email, phoneNumber);
        this.jobStartDate = jobStartDate;
        this.salary = 1000;
    }
    //constructor
    @Override
    public void createPerson(int id, String name, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.employeeId=id;
        this.employeeName=name;
        this.dateOfBirth=dateOfBirth;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
    //Methods from IPerson
    @Override
    public String calculateCategory(LocalDate jobStartDate){
        LocalDate  today=java.time.LocalDate.now();
        if (jobStartDate==null && today==null) {
            System.out.println("Please insert Employee's job start date.");
        }else{
            int seniority=Period.between(jobStartDate, today).getYears();
            if (seniority>5) {
                category=EmployeeSeniority.SENIOR.getSeniority();
                setCategory(category);
            }else if (seniority>3) {
                category=EmployeeSeniority.SEMISENIOR.getSeniority();
                setCategory(category);
            }else if (seniority>1) {
                category=EmployeeSeniority.JUNIOR.getSeniority();
                setCategory(category);
            }else{
                category=EmployeeSeniority.TRAINEE.getSeniority();
                setCategory(category);
            }
        }
        return category;
    }
    @Override
     public double calculateBenefits(String category) throws NotValidCategoryException{
         double salary=1000;
        if (category.equalsIgnoreCase("senior")) {
              //System.out.println("Seniors get 50% salary increase.");
              salary=1.5*salary;
              //employee.set.salary
        }else if (category.equalsIgnoreCase("semi senior")) {
              //System.out.println("Semi Seniors get 30% salary increase.");
              salary=1.3*salary;
              //employee.set.salary
        }else if (category.equalsIgnoreCase("junior")) {
              //System.out.println("Juniors get 15% salary increase.");
              salary=1.15*salary;
              //employee.set.salary
        }else if (category.equalsIgnoreCase("trainee")){
              //System.out.println("Trainees do not have salary increase.");
              //employee.set.salary
        }else{
            throw new NotValidCategoryException ("Please enter a valid Employee's category.");
        }
        return salary;
    }
     
     //Methods from ILinkedList
    @Override
    public CustomLinkedList createLinkedList(){
        System.out.println("=================Loading employees====================");
        
        Employee e1=new Employee(1, "John Smith", LocalDate.parse("1990-05-01") , "jsmith@mail.com", "1162547", LocalDate.parse("2011-08-01"));
        e1.setCategory(e1.calculateCategory(e1.getJobStartDate()));
        
        Employee e2=new Employee(2, "Marie Stuart", LocalDate.parse("1967-12-10") , "mstuart@mail.com", "1147895", LocalDate.parse("2019-10-16"));
        e2.setCategory(e2.calculateCategory(e2.getJobStartDate()));
        
        Employee e3=new Employee(3, "Rob Styles", LocalDate.parse("1980-10-08") , "rstyles@mail.com", "1141542", LocalDate.parse("2017-01-07"));
        e3.setCategory(e3.calculateCategory(e3.getJobStartDate()));
        
        Employee e4=new Employee(4, "Anne Robert", LocalDate.parse("1998-03-22") , "arobert@mail.com", "1146945", LocalDate.parse("2022-06-11"));
        e4.setCategory(e4.calculateCategory(e4.getJobStartDate()));
        try{
            e1.setSalary(e1.calculateBenefits(e1.getCategory()));
            e2.setSalary(e2.calculateBenefits(e2.getCategory()));
            e3.setSalary(e3.calculateBenefits(e3.getCategory()));
            e4.setSalary(e4.calculateBenefits(e4.getCategory()));
        }catch (NotValidCategoryException e) {
            System.out.println("Exception."+e.getMessage());
        }

        CustomLinkedList<Employee> employeeList=new CustomLinkedList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4); 
        
        return employeeList;
    }
    
    @Override
    public void showLinkedList(CustomLinkedList employeeList){
        System.out.println(employeeList.toString());
    }
    @Override
    public void modifyLinkedList(CustomLinkedList employeeList, Object newElement){
        Scanner sc=new Scanner(System.in);
        System.out.println("Insert position of new element, starting from 0 to "+employeeList.length());
        try{        
            int position=sc.nextInt();
            employeeList.add(position, newElement);
            System.out.println(employeeList.toString());
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds Exception.");
        }
    }
     
     //toString
    @Override
    public String toString() {
        return "Employee{" + " employeeId=" + employeeId + ", employeeName=" + employeeName 
                + "\n dateOfBirth=" + dateOfBirth 
                + "\n email=" + email 
                + "\n phoneNumber=" + phoneNumber 
                + "\n jobStartDate=" + jobStartDate 
                + "\n salary (USD)=" + salary 
                + "\n category=" + category + '}'+"\n"+"\n";
    }
     
     
    //getters from interface
    @Override
    public void setId(int id){
      this.employeeId = id;  
    }
    @Override
    public void setName(String name){
        this.employeeName=name;
    }
    @Override
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }
    @Override
    public void setEmail(String email){
        this.email=email;
    }
    @Override
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    
   //getters and setters
    public LocalDate getJobStartDate() {
        return jobStartDate;
    }
    public void setJobStartDate(LocalDate jobStartDate) {
        this.jobStartDate = jobStartDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    }

    