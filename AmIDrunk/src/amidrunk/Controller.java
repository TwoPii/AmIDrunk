/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amidrunk;
import java.util.*;
import java.io.*;

/**
 *
 * @author genis
 */
public class Controller {
    
    private Drinker drinker;
    private File f;
            
    public Controller (){

        drinker = loadDrinker();
        //stuff
        saveDrinker(drinker);
        

    }
    
    public void saveDrinker(Drinker t){
    
        //int weight = getWeight();
        //boolean gender = getGender();
        //int time = getTimeToBeFine();
        
    }
    
    public Drinker loadDrinker(){
        
        Drinker t;
        try{
            String name = showFile(0);
            String weight = showFile(1);
            String gender = showFile(2);
            String time = showFile(3);
            Drink d;
            boolean m;
            int vol;
            int grade;
            int nameD;
            String drinkTime;
            int i = 4;
            if (gender == "M") m = true;
            else m = false;
            t = new Drinker(Integer.parseInt(weight),m,0);
            while(showFile(i) != "END"){
                nameD = Integer.parseInt(showFile(i));
                vol = Integer.parseInt(showFile(++i));
                grade = Integer.parseInt(showFile(++i));
                drinkTime = showFile (++i);
                d = new Drink(nameD,grade,vol,Integer.parseInt(drinkTime));
                t.addDrink(d);
            }
            return t;
        } catch (IOException e){
            t = new Drinker(0,true,0);
            return t;
        }
    }
    public void writeFile(String line) throws FileNotFoundException, IOException{
    
        String ruta = "data.txt";
        File f = new File (ruta);
        BufferedWriter bw;
        bw = new BufferedWriter(new  FileWriter(f)); 
        bw.write(line);
        bw.close();

    }
    
    public String showFile(int line) throws FileNotFoundException, IOException{
    
        String str;
        int count = 0;
        FileReader f = new FileReader("data.txt");
        BufferedReader b = new BufferedReader(f);
        while((str = b.readLine())!= null && count < line) count++;
        return str;
    }
}
