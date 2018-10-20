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
    private Time timeToBeFine;
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

    public Time getTimeToBeFine() {
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

    public void addDrink(Drink d){
        this.drinksArray.add(d);     
        this.calculateAlcoholism(d);
    }
    
    public double calculateAlcoholism(Drink d){
        Time actualTime = new Time();
                
        this.actualBAC = this.actualBAC - B * actualTime.getMinTimeDifference(this.lastDrinkTime) + d.getGrams() * 100 / this.weight / this.R - B * actualTime.getMinTimeDifference(d.getDrinkTime());
        this.lastDrinkTime = actualTime;
        
        this.calculateTimeToBeFine();
        
        return this.actualBAC;
    }

    public void setTimeToBeFine(Time timeToBeFine) {
        this.timeToBeFine = timeToBeFine;
    }

    public void setActualBAC(double actualBAC) {
        this.actualBAC = actualBAC;
    }

    public void setLastDrinkTime(Time lastDrinkTime) {
        this.lastDrinkTime = lastDrinkTime;
    }

    public void setDrinksArray(ArrayList<Drink> drinksArray) {
        this.drinksArray = drinksArray;
    }
    
    
    public int getDrinksAmount(){
        return this.drinksArray.size();        
    }
    
    public Drink getDrink(int i){
        return this.drinksArray.get(i);
    }
    
    public Time calculateTimeToBeFine(){
        //Time to be fine is the time when BAC <= 0;
        //t = Co-Ct/B = Co/B
        int totalMin;
        int day = 0;
        int hour = 0;
        int min = 0;
        
        totalMin = (int) ((int) this.actualBAC/B);
        
        min = (int) totalMin%60;
        hour = (int) totalMin/60;
        
        day = (int) hour/60;
        hour = (int) hour%60;
        
        return new Time(day, hour, min, 0);
    }

    public boolean isGender() {
        return gender;
    }

    public double getActualBAC() {
        return actualBAC;
    }

    public Time getLastDrinkTime() {
        return lastDrinkTime;
    }
    
    
    public boolean canDrive(){
        return this.actualBAC <= 0;
    }         
}
