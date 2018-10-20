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
    public static final int BEER = 0;
    public static final int COCKTAIL = 1;
    public static final int SHOT = 2;
    public static final int WINE = 3;
    public static final int OTHER = 4;
    private int name;
    private int graduation;
    private int volum;
    private double grams;
    private Time drinkTime;

    public Drink(int name, int graduation, int volum, Time drinkTime) {
        this.name = name;
        this.graduation = graduation;
        this.volum = volum;
        this.drinkTime = new Time(drinkTime.day, drinkTime.hour, drinkTime.min, drinkTime.sec);
        this.grams = ((volum*graduation*0.8)/100) ;
    }

    public double getGrams() {
        return grams;
    }

    public Time getDrinkTime() {
        return drinkTime;
    }

    public int getName() {
        return name;
    }

    public int getGraduation() {
        return graduation;
    }

    public int getVolum() {
        return volum;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setGraduation(int graduation) {
        this.graduation = graduation;
    }

    public void setVolum(int volum) {
        this.volum = volum;
    }

    public void calculeGrams(double grams) {
        this.grams = ((volum*graduation*0.8)/100) ;
    }

    public void setDrinkTime(Time drinkTime) {
        this.drinkTime = drinkTime;
    }
    
    
}
