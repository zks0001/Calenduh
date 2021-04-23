/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

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
    public ArrayList Days = new ArrayList<Day>();
            
            
    public Month(YearMonth when_)
    {
        when = when_;
        length = when.lengthOfMonth();
        offset = (when.atDay(1).getDayOfWeek().getValue()) % 7;
        Days = new ArrayList<Day>(length);
        for (int i = 1; i <= length; i++)
        {
            this.append(new Day(when.atDay(i)));
        }
    }
    
    private void append(Day obj)
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
    
    public int getLength()
    {
        return length;
    }
    
    public Day getDay(int dayNum)
    {
        return (Day) Days.get(dayNum);
    }
}
