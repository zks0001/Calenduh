/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.time.YearMonth;
import java.util.ArrayList;

/**
 *
 * @author dudes
 */
public class Month {
    protected YearMonth when;           
    protected Integer length;
    protected Integer offset;
    public ArrayList Days = new ArrayList<Activity>();; 
            
            
    public Month(YearMonth when_)
    {
        when = when_;
        length = when.lengthOfMonth();
        offset = (when.atDay(1).getDayOfWeek().getValue()) % 7;
        Days = new ArrayList<>(length);
    }
    
    public void append(Day obj)
    {
        Days.add(obj);
    }
    
    public void rem(Day obj)
    {
        Days.remove(obj);
    }
    
    public int off()
    {
        return offset;
    }
}
