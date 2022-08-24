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

public interface ILinkedList {
    public CustomLinkedList createLinkedList();
    public void showLinkedList(CustomLinkedList list);
    public void modifyLinkedList(CustomLinkedList list, Object newElement);
}
