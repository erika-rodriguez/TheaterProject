/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

/**
 *
 * @author Erika92
 */
public abstract class Show {
    protected String showName;
    protected int duration;
    protected String genre;//orchestra, ballet, opera, chore, musical

    public String getShowName() {
        return showName;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }
    
}
