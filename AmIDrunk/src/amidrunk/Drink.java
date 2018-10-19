/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amidrunk;

/**
 *
 * @author kurur
 */
public class Drink {
    private char name;
    private int graduation;
    private int volum;
    private double grams;
    private int drinktime;

    public Drink(char name, int graduation, int volum, int drinktime) {
        this.name = name;
        this.graduation = graduation;
        this.volum = volum;
        this.drinktime = drinktime;
        this.grams = ((volum*graduation*0.8)/100) ;
    }

    public double getGrams() {
        return grams;
    }

    public int getDrinktime() {
        return drinktime;
    }
    
    
}
