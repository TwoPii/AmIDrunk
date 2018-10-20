/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amidrunk;

import static amidrunk.Controller.BEER;
import static amidrunk.Controller.COCKTAIL;

/**
 *
 * @author genis
 */
public class main {
    
    
    public static void main(String[] args) {
        Drinker k;
        Controller c;
        c = new Controller();
        k = c.loadDrinker();
        if(k.getName() == ""){
            k = new Drinker("Genis",70,true,0);
        }
        Drink md1 = new Drink(BEER,4,330,new Time());
        Drink md2 = new Drink(COCKTAIL, 12, 200, new Time());
        k.addDrink(md1);
        k.addDrink(md2);
        k.canDrive();
        c.saveDrinker(k);
        
    }
}
