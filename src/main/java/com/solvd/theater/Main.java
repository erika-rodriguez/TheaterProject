/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //FOR ADMIN
        Manager m=new Manager();
        logger.info("-------------Admin Menu-----------------");
        int selection;
        do {
            logger.info("-------------Choose an option-----------------");
            Scanner sn=new Scanner(System.in);
            selection=sn.nextInt();
            switch (selection){
                case 1:m.createEmployeeList();
                    break;
                case 2:m.modifyEmployeeList(m.createEmployeeList());
                    break;
                case 3:m.createCustomersList();
                    break;
                case 4:m.modifyCustomersList(m.createCustomersList());
                    break;
            }
        }while(selection!=5);

        //For the USER
        TheaterManagement tm=new TheaterManagement();
        logger.info("Welcome!This is your Ticket Assistant");
        int option;
        do {
            logger.info("-------------Choose an option-----------------");
            Scanner sc=new Scanner(System.in);
            option=sc.nextInt();
            switch (option){
                case 1:tm.createTheaters(tm);
                    break;
                case 2:tm.createPlays(tm);
                    break;
                case 3:tm.createTM(tm);
                    logger.info("Enjoy the show!");
                    logger.info("-----------------------------------------");
                    break;
            }
        }while (option!=4);
    }
}
