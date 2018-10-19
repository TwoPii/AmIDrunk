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
    
    private ArrayList<Drinker> drinkers;
    private File f;
            
    public Controller (){
        drinkers = new ArrayList<Drinker>();
        

    }
    public void writeFile(String line){
    
        String ruta = "data.txt";
        File f = new File (ruta);
        BufferedWriter bw;
        try{
            bw = new BufferedWriter(new  FileWriter(f)); 
            bw.write(line);
            bw.close();
        } catch (IOException a) {
                
        }
    }
    
    public String showFile(int line) throws FileNotFoundException, IOException{
    
        String str;
        int count = 0;
        FileReader f = new FileReader("data.txt");
        BufferedReader b = new BufferedReader(f);
        while((str = b.readLine())!= null && line > count);
        return str;
    }
}
