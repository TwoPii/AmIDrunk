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
    private String name;
    private ArrayList<Drink> drinksArray;
    public static double R;
    public static double B;

    public Drinker(String name, int weight, boolean gender, int numberOfDrinks) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
        this.drinksArray = new ArrayList<Drink>(numberOfDrinks);
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
    
    public double actualAlcoholism(){
        double[] alcoholGrams = new double[this.drinksArray.size()];
        double[] initialBAC = new double[this.drinksArray.size()];
        double finalBAC = 0;
        for(int i = 0; i < this.drinksArray.size(); i++){
            alcoholGrams[i] = (double) (this.drinksArray.get(i).getVolum()*this.drinksArray.get(i).getGraduation()*0.8);           
            initialBAC[i] = alcoholGrams[i] * 100 / this.weight / this.R;
            finalBAC = initialBAC[i] - B * this.drinksArray.get(i).getDrinktime() + finalBAC;
        }
        
        
        
        
        return 0;
    }
    
    public boolean canDrive(){
        if(this.timeToBeFine <= 0)
            return true;
        else
            return false;
    }
    
    
            
            
}
