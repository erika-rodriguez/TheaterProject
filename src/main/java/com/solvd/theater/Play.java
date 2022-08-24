/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solvd.theater;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Erika92
 */
public class Play extends Show{
    private int id;
    //constructors
    public Play() {
        super();
    }
    
    public Play(String playName, int playDuration,String kind){
        showName=playName;
        duration=playDuration;
        genre=kind;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Methods
    public  ArrayList<Play> createList() {
        Play play1=new Play("Moulin Rouge", 120, "Musical");
        Play play2=new Play("The Lion King", 150, "Musical");
        Play play3=new Play("Cats musical", 130,"Musical");
        Play play4=new Play("Hamlet", 160, "Drama");
        Play play5=new Play("Swan Lake", 160, "Ballet");

        ArrayList <Play> playList=new ArrayList<>();
        playList.add(play1);
        playList.add(play2);
        playList.add(play3);
        playList.add(play4);
        playList.add(play5);

        return playList;
    }
    

    public void readList(ArrayList<Play> list) {
         for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1)+". "+"["+list.get(i).getShowName()+"] "+"Duration(min): "+list.get(i).getDuration());
        }
    }
    public ArrayList <Play> modifyPlay(ArrayList <Play> playList, int option) {
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getId()==option){
                System.out.println("Insert the updated Play Name:");
                String newName=sc.nextLine();
                int newDuration=sc.nextInt();
                playList.get(i).setShowName(newName);
                playList.get(i).setDuration(newDuration);
                break;
            }
        }
        return  playList;
    }

   
    public ArrayList <Play> deletePlay(ArrayList <Play> playList, int option) {
        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getId()==option){
                playList.remove(i);
                break;
            }
        }
        return  playList;
    }

}
