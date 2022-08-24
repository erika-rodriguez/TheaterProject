/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import java.util.InputMismatchException;

/**
 *
 * @author Erika92
 */
public class NotValidInputException extends InputMismatchException{

    public NotValidInputException(String string) {
        super(string);
    }

    
}
