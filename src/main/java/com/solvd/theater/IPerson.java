/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import java.time.LocalDate;


/**
 *
 * @author Erika92
 */
public interface IPerson {
//    private int id;
//    private String name;
//    private final Date dateOfBirth;

    public void createPerson(int id, String name, LocalDate dateOfBirth,String email, String phoneNumber);
    public String calculateCategory(LocalDate date);
    public double calculateBenefits(String category)throws NotValidCategoryException;
    
    
    //setters
    public void setId(int id);
    public void setName(String name);
    public void setDateOfBirth(LocalDate dateOfBirth);
    public void setEmail(String email);
    public void setPhoneNumber(String phoneNumber);

}
