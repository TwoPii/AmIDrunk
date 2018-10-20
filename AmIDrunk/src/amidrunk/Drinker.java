/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amidrunk;

import java.util.ArrayList;

/**
 *
 * @author gisse
 */
public class Drinker {
    private int weight;
    private boolean gender;
    private int timeToBeFine;
    private double actualBAC; 
    private Time lastDrinkTime;
    private String name;
    private ArrayList<Drink> drinksArray;
    public static double R;
    public static double B;

    public Drinker(String name, int weight, boolean gender, int numberOfDrinks) {
        this.name = name;
        this.weight = weight * 1000;
        this.gender = gender;
        this.drinksArray = new ArrayList<Drink>(numberOfDrinks);
        this.actualBAC = 0;
        this.lastDrinkTime = new Time();
        if(gender){
            R = 0.55;
            B = 0.0025;
        } else {
            R = 0.68;
            B = 0.0026;
        }
    }
           

    public String getName(){
            return this.name;
    }
   
    public int getWeight() {
        return weight;
    }

    public boolean getGender() {
        return gender;
    }

    public int getTimeToBeFine() {
        return timeToBeFine;
    }

    public ArrayList<Drink> getDrinksArray() {
        return drinksArray;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void calculateTimeToBeFine(int timeToBeFine) {
        this.timeToBeFine = timeToBeFine;
    }

    public void addDrink(Drink d){
        this.drinksArray.add(d);       
    }
    
    public double calculateAlcoholism(Drink d){
        Time actualTime = new Time();
                
        this.actualBAC = this.actualBAC - B * actualTime.getMinTimeDifference(this.lastDrinkTime) + d.getGrams() * 100 / this.weight / this.R - B * actualTime.getMinTimeDifference(d.getDrinkTime());
        this.lastDrinkTime = actualTime;
        
        return this.actualBAC;
    }
    
    public int getDrinksAmount(){
        return this.drinksArray.size();        
    }
    
    public Drink getDrink(int i){
        return this.drinksArray.get(i);
    }
    
    public boolean canDrive(){
        if(this.timeToBeFine <= 0)
            return true;
        else
            return false;
    }         
}
