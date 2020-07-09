/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author User
 */
public interface ListInterface <T>{
    boolean add(T element);
    void remove(T element);
    T getValueOf(int i);
    boolean isEmpty();
    void clear();
    Object[] getAll();
    int size();
    void doubleArray();
    boolean contain(T element);
}
