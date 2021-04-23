package top;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Benjamin Jones
 */
public class Workout extends Activity {
    private String[] muscles;
    private int calories;
    
    public Workout()
    {
    	muscles = null;
    	calories = 0;
    	startTime = null;
    	date = null;
    	location = "";
    	extraInfo = "";
    }

    public Workout(LocalTime time_, LocalDate date_, String location_, String[] muscles_, int calories_)
    {
    	startTime = time_;
    	date = date_;
    	location = location_;
    	extraInfo = "workout";
    	muscles = muscles_;
    	calories = calories_;
    }
    
    public void setMuscles(String[] newMuscles)
    {
        muscles = newMuscles;
    }
    
    public void setCalories(int newCalories)
    {
        calories = newCalories;
    }
    
    public String[] getMuscles()
    {
        return muscles;
    }
    
    public int getCalories()
    {
        return calories;
    }
}
