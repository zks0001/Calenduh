/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import java.util.*;
import java.time.*;
/**
 *
 * @author jjdre
 */
public class Day 
{
    protected LocalDate date;
    protected int arrSize = 0;
    public ArrayList activityList = new ArrayList<Activity>();
    
    public Day(LocalDate date_)
    {
        date = date_;
    }
    
    public void Add(Activity a)
    {
        activityList.add(a);
        arrSize = arrSize + 1;
    }
    
    public void Remove(Activity a)
    {
        activityList.remove(a);
        arrSize = arrSize - 1;
    }
    
}
