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
    private ArrayList<Drink> drinksArray;

    public Drinker(int weight, boolean gender, int numberOfDrinks) {
        this.weight = weight;
        this.gender = gender;
        this.drinksArray = new ArrayList<Drink>(numberOfDrinks);
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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setTimeToBeFine(int timeToBeFine) {
        this.timeToBeFine = timeToBeFine;
    }

    public void addDrink(Drink d){
        this.drinksArray.add(d);       
    }
    
    public float calculateAlcoholism(){
        
        
        return 0;
    }
    
    public boolean canDrive(){
        if(this.timeToBeFine <= 0)
            return true;
        else
            return false;
    }
    
    
            
            
}
