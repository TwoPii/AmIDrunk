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
public int GetActualmonth(){
return Calendar.get(Calendar.MONTH);
}
public int GetActualday(){
return Calendar.get(Calendar.DATE);
}
public int GetActualyear(){
return Calendar.get(Calendar.YEAR);
}
public double GetCodeDate(){
int h = this.GetActualhour();
int m = this.GetActualmin();
int s = this.GetActualsec();
int M = this.GetActualmonth();
int d = this.GetActualday();
int y = this.GetActualyear();
return s+m*100+h*10000+d*1000000+M*100000000;
}
/*   public static void main(String[] args) {
    Time t = new Time();
    int h = t.GetActualhour();
    int m = t.GetActualmin();
    int s = t.GetActualsec();
    int M = t.GetActualmonth();
    int d = t.GetActualday();
    int y = t.GetActualyear();
    
    System.out.println(h+":"+m+":"+s+" del dia "+d+ " del mes " +M+ " del año" +y);
    System.out.println(t.GetCodeDate());
}*/
}
