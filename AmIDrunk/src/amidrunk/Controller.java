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
    public static final int BEER = 0;
    public static final int COCKTAIL = 1;
    public static final int SHOT = 2;
    public static final int WINE = 3;
    public static final int OTHER = 4;
            
    public Controller (){
        
    }
    
    public Drinker createDrinker(String name, String weight, String gender){
        boolean gndr = false;
        if(gender == "M") gndr = true;
        int wght = Integer.parseInt(weight);
        Drinker d = new Drinker(name,wght,gndr,0);
        return d;
    }
    public void saveDrinker(Drinker t){
    
        String name = t.getName();
        int weight = t.getWeight();
        boolean gender = t.getGender();
        Time time = t.getTimeToBeFine();
        int dayf = time.day;
        int hourf = time.hour;
        int minf = time.min;
        ArrayList<String> text;
        try{              
            String gndr = "F";
            if(gender)gndr = "M";                                
            double actualBAC = t.getActualBAC();
            text = new ArrayList<String>();
            text.add(name+"\n");
            text.add(Integer.toString(weight)+"\n");
            text.add(gndr+"\n");
            text.add(Double.toString(actualBAC)+"\n");
            text.add(dayf + " " + hourf + " " + minf+" " + "0 \n");
            for(int i = 0; i < t.getDrinksAmount(); i++){
                Drink d = t.getDrink(i);
                String nameD = Integer.toString(d.getName());   
                String vol = Integer.toString(d.getVolum());
                String grade = Integer.toString(d.getGraduation());
                Time drinkTime = d.getDrinkTime();
                int day = drinkTime.day;
                int hour = drinkTime.hour;
                int minute = drinkTime.min;
                text.add(nameD+"\n");
                text.add(vol+"\n");
                text.add(grade+"\n");
                text.add(day + " " + hour + " " + minute + " " + 0+"\n");
            }
            text.add("-");
            try{ writeFile(text);} catch (FileNotFoundException e){}


        } catch (IOException e){
            
        }
        
    }
    
    public Drinker loadDrinker(){
        
        Drinker t;
        try{
            String name = showFile(0);
            String weight = showFile(1);
            String gender = showFile(2);
            String actualBAC = showFile(3);
            String timetobefine = showFile(4);
            String []tim = timetobefine.split(" ");
            Drink d;
            boolean m;
            int vol;
            int grade;
            int nameD;
            Time timetobfine;
            String drinkTime;
            int i = 5;
            if (gender == "M") m = true;
            else m = false;
            t = new Drinker(name,Integer.parseInt(weight),m,0);
            t.setActualBAC(Double.parseDouble(actualBAC));
            timetobfine = new Time (Integer.parseInt(tim[0]),Integer.parseInt(tim[1]) ,Integer.parseInt(tim[2]), Integer.parseInt(tim[3]));
            while(showFile(i).charAt(0) != '-'){
                System.out.println(showFile(i));
                nameD = Integer.parseInt(showFile(i));
                vol = Integer.parseInt(showFile(++i));
                grade = Integer.parseInt(showFile(++i));
                drinkTime = showFile (++i);
                String []dt = drinkTime.split(" ");
                d = new Drink(nameD,grade,vol,new Time(Integer.parseInt(dt[0]),Integer.parseInt(dt[1]),Integer.parseInt(dt[2]),Integer.parseInt(dt[3])));
                t.addDrink(d);
                ++i;
            }
            return t;
        } catch (IOException e){
            t = new Drinker("",0,true,0);
            return t;
        }
    }
    public void writeFile(ArrayList<String> line) throws FileNotFoundException, IOException{
    
        String ruta = "data.txt";
        File f = new File (ruta);
        BufferedWriter bw;
        bw = new BufferedWriter(new  FileWriter(f)); 
        for(int i = 0; i < line.size(); i++){
            bw.write(line.get(i));
        }
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
