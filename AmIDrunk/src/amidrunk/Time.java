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
    int day;
    int hour;
    int min;
    int sec;
    Calendar Calendar = new GregorianCalendar();

    public Time() {
        this.day = this.getActualDay();
        this.hour = this.getActualHour();
        this.min = this.getActualMin();
        this.sec = this.getActualSec();       
    }
    
    public Time(int day, int hour, int min, int sec){
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.sec = sec;       
    }

public int getActualHour(){
return Calendar.get(Calendar.HOUR_OF_DAY);
}
public int getActualMin(){
return Calendar.get(Calendar.MINUTE);
}
public int getActualSec(){
return Calendar.get(Calendar.SECOND);
}
public int GetActualmonth(){
return Calendar.get(Calendar.MONTH);
}
public int getActualDay(){
return Calendar.get(Calendar.DATE);
}
public int GetActualyear(){
return Calendar.get(Calendar.YEAR);
}
public double GetCodeDate(){
int h = this.getActualHour();
int m = this.getActualMin();
int s = this.getActualSec();
int M = this.GetActualmonth();
int d = this.getActualDay();
int y = this.GetActualyear();
return s+m*100+h*10000+d*1000000+M*100000000;
}

public int getMinTimeDifference(Time t2){
    int dHour;
    int dMin;
    
    dHour = this.hour - t2.hour;
    dMin = this.min - t2.min;
    
    if(dHour < 0){
        dHour = 24 + dHour;
    }
    
    if(dMin < 0){
        dMin = 60 + dMin;
        dHour = dHour - 1;
    }

    return 60*dHour + dMin;
}


    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }
}
