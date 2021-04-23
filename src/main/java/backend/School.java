package backend;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Benjamin Jones
 */
public class School extends Activity {
    
    private String course;
    private float grade;
    private int hours;
    private String[] assignments;
    
    public School()
    {
    	startTime = null;
    	date = null;
    	location = "";
    	extraInfo = "";
    	course = "";
    	grade = 0;
    	hours = 0;
    	assignments = null;
    }

    public School(LocalTime time_, LocalDate date_, String location_, String course_, float grade_, int hours_, String[] assignments_)
    {
    	startTime = time_;
    	date = date_;
    	location = location_;
    	extraInfo = "school";
    	course = course_;
    	grade = grade_;
    	hours = hours_;
    	assignments = assignments_;
    }
    
    public void setCourse(String newCourse)
    {
        course = newCourse;
    }
    
    public void setGrade(float newGrade)
    {
        grade = newGrade;
    }
    
    public void setHours(int newHours)
    {
        hours = newHours;
    }
    
    public void setAssignments(String[] newAssignments)
    {
        assignments = newAssignments;
    }
    
    public String getCourse()
    {
        return course;
    }
    
    public float getGrade()
    {
        return grade;
    }
    
    public int getHours()
    {
        return hours;
    }
    
    public String[] getAssignments()
    {
        return assignments;
    }
}

