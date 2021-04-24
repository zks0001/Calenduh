/*
 * 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;
import java.util.*;
import java.time.*;
import java.io.Serializable;
import static java.time.temporal.ChronoUnit.MINUTES;
/**
 *
 * @author Benjamin Jones and me too
 */
public class Activity implements Serializable{
    protected LocalTime startTime;
    protected LocalTime stopTime;
    protected LocalDate date;
    protected String location;
    protected String extraInfo;
    protected long duration;
    protected String name;
    
    public Activity()
    {
    	startTime = null;
        stopTime = null;
    	date = null;
    	location = "";
    	extraInfo = "";
        duration = 60;
    }
    
    public Activity(LocalTime startTime_, LocalDate date_, String location_, String extraInfo_)
    {
    	startTime = startTime_;
    	date = date_;
    	location = location_;
    	extraInfo = extraInfo_;
    }
    
    public Activity(LocalTime startTime_, LocalTime stopTime_, LocalDate date_, String location_, String extraInfo_, String name_, long duration_)
    {
    	startTime = startTime_;
        stopTime = stopTime_;
    	date = date_;
    	location = location_;
    	extraInfo = extraInfo_;
        duration = startTime.until(stopTime, MINUTES);
        name = name_;
    }
    
//    public Activity(LocalTime startTime_, LocalDate date_, String location_, String extraInfo_, long duration_)
//    {
//    	startTime = startTime_;
//    	date = date_;
//    	location = location_;
//    	extraInfo = extraInfo_;
//        duration = duration_;
//        stopTime = startTime.plusMinutes(duration);
//    }
    
    public void setstopTime(LocalTime newTime)
    {
        stopTime = newTime;
    }
    
    public void setstartTime(LocalTime newTime)
    {
        startTime = newTime;
    }
    
    public void setDate(LocalDate newDate)
    {
        date = newDate;
    }
    
    public void setLocation(String newLocation)
    {
        location = newLocation;
    }
    
    public void setExtraInfo(String newExtraInfo)
    {
        extraInfo = newExtraInfo;
    }
    
    public void setDuration(long duration_)
    {
        duration = duration_;
    }
    
    public LocalTime getStartTime()
    {
        return startTime;
    }
    
    public LocalTime getStopTime()
    {
        return stopTime;
    }
    
    public LocalDate getDate()
    {
        return date;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String getExtraInfo()
    {
        return extraInfo;
    }
    
    public long getDuration()
    {
        return duration;
    }
    
}

