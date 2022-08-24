/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Erika92
 */
public class Manager {

    public CustomLinkedList createEmployeeList(){
        Employee e=new Employee();
        CustomLinkedList employeeList=e.createLinkedList();
        e.showLinkedList(employeeList);
        return employeeList; 
    }
    public void modifyEmployeeList(CustomLinkedList employeeList){
        Scanner sc=new Scanner(System.in);
        Employee e=new Employee();
        System.out.println("Insert Employee's information:");
        System.out.println("Id:");
        int id=sc.nextInt();
        System.out.println("Name:");
        String name=sc.nextLine();
        System.out.println("Date of Birth (YYYY-MM-DD):");
        LocalDate dateOfBirth=LocalDate.parse(sc.nextLine());
        System.out.println("Email:");
        String email=sc.nextLine();
        System.out.println("PhoneNumber:");
        String phoneNumber=sc.nextLine();
        System.out.println("Date of JobStart (YYYY-MM-DD):");
        LocalDate dateJobStart=LocalDate.parse(sc.nextLine());
        
        Employee newEmployee=new Employee(id, name, dateOfBirth, email, phoneNumber, dateJobStart);
        e.modifyLinkedList(employeeList, newEmployee);
        e.showLinkedList(employeeList);
    }
    public void createCustomersList(){
        Customer c=new Customer();
        c.showLinkedList(c.createLinkedList());
    }
    public void modifyCustomersList(CustomLinkedList customerList){
        Scanner sc=new Scanner(System.in);
        Customer c=new Customer();

        System.out.println("Insert Customer's information:");
        System.out.println("Id:");
        int id=sc.nextInt();
        System.out.println("Name:");
        String name=sc.next();
        System.out.println("Date of Birth (YYYY-MM-DD):");
        LocalDate dateOfBirth=LocalDate.parse(sc.next());
        System.out.println("Email:");
        String email=sc.next();
        System.out.println("PhoneNumber:");
        String phoneNumber=sc.next();

        
        Customer newCustomer=new Customer(id, name, dateOfBirth, email, phoneNumber);
        c.modifyLinkedList(customerList, newCustomer);
        c.showLinkedList(customerList);
    }
    
    
}
