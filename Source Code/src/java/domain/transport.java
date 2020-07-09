/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author tanyj
 */
public class transport {
    private int trans_id;
    private String name;
    private int speed;
    private double cost;
    private double totalCost;
  
    private int Minutes; 
    private int Hours; 

    public int getMinutes() {
        return Minutes;
    }

    public int getHours() {
        return Hours;
    }

    public void setMinutes(int Minutes) {
        this.Minutes = Minutes;
    }

    public void setHours(int Hours) {
        this.Hours = Hours;
    }

  
    
    public transport(int trans_id, String name, int speed, double cost) {
        this.trans_id = trans_id;
        this.name = name;
        this.speed = speed;
        this.cost = cost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public transport() {
        this.totalCost= 0;
    }

    public int getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(int trans_id) {
        this.trans_id = trans_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
}
