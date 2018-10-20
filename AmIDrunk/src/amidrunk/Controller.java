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
    
        String name = t.getName();
        int weight = t.getWeight();
        boolean gender = t.getGender();
        Time time = t.getTimeToBeFine();
        int dayf = time.day;
        int hourf = time.hour;
        int minf = time.min;
        try{
            writeFile(name);                                    //Nombre        (1)
            writeFile(Integer.toString(weight));                //Peso          (2)
            String gndr = "F";
            if(gender)gndr = "M";
            writeFile(gndr);                                    //Genero        (3)
            double actualBAC = t.getActualBAC();
            writeFile(Double.toString(actualBAC));              //BAC           (4)
            writeFile(dayf + " " + hourf + " " + minf);         //TimetoBeFine  (5)
            
            for(int i = 0; i < t.getDrinksAmount(); i++){
                Drink d = t.getDrink(i);
                String nameD = Integer.toString(d.getName());   
                String vol = Integer.toString(d.getVolum());
                String grade = Integer.toString(d.getGraduation());
                Time drinkTime = d.getDrinkTime();
                int day = drinkTime.day;
                int hour = drinkTime.hour;
                int minute = drinkTime.min;
                writeFile(nameD);                               //Nombre alcohol(6)
                writeFile(vol);                                 //Volumen       (7)
                writeFile(grade);                               //Graduacion    (8)
                writeFile(day + " " + hour + " " + minute + " " + 0);     //Tiempo bebida (9)
            }

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
            while(showFile(i) != "END"){
                nameD = Integer.parseInt(showFile(i));
                vol = Integer.parseInt(showFile(++i));
                grade = Integer.parseInt(showFile(++i));
                drinkTime = showFile (++i);
                String []dt = drinkTime.split(" ");
                d = new Drink(nameD,grade,vol,new Time(Integer.parseInt(dt[0]),Integer.parseInt(dt[1]),Integer.parseInt(dt[2]),Integer.parseInt(dt[3])));
                t.addDrink(d);
            }
            return t;
        } catch (IOException e){
            t = new Drinker("",0,true,0);
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
