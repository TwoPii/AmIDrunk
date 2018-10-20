/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amidrunk;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
     
/**
 *
 * @author kurur
 */
public class Time {
Calendar Calendar = new GregorianCalendar();
public int GetActualhour(){
return Calendar.get(Calendar.HOUR_OF_DAY);
}
public int GetActualmin(){
return Calendar.get(Calendar.MINUTE);
}
public int GetActualsec(){
return Calendar.get(Calendar.SECOND);
}
}