package top;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.YearMonth;

public class HelloWorld {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Activity> sorted = new ArrayList<Activity>();
		
		//this needs to be made into a school class
		String assign1[] = {"work on mortar aiming", "work on horizontal"};
		School s1 = new School(LocalTime.of(10, 30), LocalDate.of(2021, 4, 17), "Ty's house", "Senior Design", 98, 3, assign1);
		
		String assign2[] = {"video game"};
		School s2 = new School(LocalTime.of(23, 59), LocalDate.of(2021, 5, 1), "n/a", "Video Game Design", 99, 3, assign2);
		
		String muscles1[] = {"lower back", "deltoids", "biceps"};
		Workout w1 = new Workout(LocalTime.of(7, 0), LocalDate.of(2021, 4, 17), "gym", muscles1, 578);
		
		String muscles2[] = {"pectorals", "triceps", "abs"};
		Workout w2 = new Workout(LocalTime.of(5, 30), LocalDate.of(2021, 4, 19), "gym", muscles2, 495);
		
		String muscles3[] = {"hiking"};
		Workout w3 = new Workout(LocalTime.of(7, 45), LocalDate.of(2021, 4, 18), "Monte Sano", muscles3, 317);
		
		Activity a1 = new Activity(LocalTime.of(15, 30), LocalDate.of(2021, 4, 20), "Moderne", "Move In!");
		Activity a2 = new Activity(LocalTime.of(19, 21), LocalDate.of(2021, 4, 16), "Home", "date night");
		Activity a3 = new Activity(LocalTime.of(20, 30), LocalDate.of(2021, 4, 23), "Moderne", "Family here");
		
		Activity acts[] = {a1, a2, a3, s1, s2, w1, w2, w3};
		String filepath = "database.txt";
		
                int dayOfMonth;
                YearMonth april = YearMonth.of(2021, 4); 
                Month aprilMonth = new Month(april);
                
		try {
			FileWriter fo = new FileWriter(filepath);
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
			for (int i = 0; i < acts.length; i++)
			{
				objectOut.writeObject(acts[i].getExtraInfo());
				objectOut.writeObject(acts[i]);
			}
			
			objectOut.close();
			fo.close();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Object testIn;
		boolean y = true;
		
		try {
			Scanner scan = new Scanner(filepath);
			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			while (fileIn.available() > 0)
			{
				
				testIn = objectIn.readObject();
				if (testIn == null)
				{
					y = false;
				}
				String x = testIn.toString();
				//System.out.println(testIn);
				switch(x) {
				case "school":
					School sTest = new School();
					sTest = (School) objectIn.readObject();
					sorted.add(sTest);
					dayOfMonth = sTest.getDate().getDayOfMonth();
                                        aprilMonth.getDay(dayOfMonth).Add(sTest);
					break;
				case "workout":
					Workout wTest = new Workout();
					wTest = (Workout) objectIn.readObject();
					sorted.add(wTest);
                                        dayOfMonth = wTest.getDate().getDayOfMonth();
                                        aprilMonth.getDay(dayOfMonth).Add(wTest);
                                        break;
				default:
					Activity aTest = new Activity();
					aTest = (Activity) objectIn.readObject();
					sorted.add(aTest);
                                        dayOfMonth = aTest.getDate().getDayOfMonth();
                                        aprilMonth.getDay(dayOfMonth).Add(aTest);
					break;
				}	
				//System.out.println();
			}
			scan.close();
			objectIn.close();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// TIME TO SORT!		
		
		//sorted.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
		
//		sorted.sort((o1, o2) -> {
//			if (o1.getDate() != o2.getDate()) {
//				return o1.getDate().compareTo(o2.getDate());
//			}
//			else {
//				return o1.getTime().compareTo(o2.getTime());
//			}
//		});
		
		sorted.sort((o1, o2) -> {
			if (o1.getDate().compareTo(o2.getDate()) == 0) {
				return o1.getStartTime().compareTo(o2.getStartTime());
			}
			return o1.getDate().compareTo(o2.getDate());
			
		});
		
		
		/*
		Arrays.sort(sortArr, (first, second) -> {
			if (first.getDate() != second.getDate()) {
				return first.getDate().compareTo(second.getDate());
			}
			
			return first.getTime().compareTo(second.getTime());
		});
		
		for (int i = 0; i < sorted.size(); i++)
		{
			switch (sorted.get(i).extraInfo) {
			case "school":
				School x = (School) sorted.get(i);
				printDaSchool(x);
				break;
			case "workout":
				Workout w = (Workout) sorted.get(i);
				printDaWorkout(w);
				break;
			default:
				printDaActivity(sorted.get(i));
				break;
			}
		}
		*/
                
                for (int i = 0; i < aprilMonth.length; i++)
                {
                    Day dayTest = (Day) aprilMonth.getDay(i); 
                    for (int j = 0; j < dayTest.activityList.size(); j++)
                    {
                        if (dayTest.hasContent)
                        {
                            Activity curAct = (Activity) dayTest.activityList.get(j);
                            switch (curAct.extraInfo) {
                                case "school":
                                        School x = (School) curAct;
                                        printDaSchool(x);
                                        break;
                                case "workout":
                                        Workout w = (Workout) curAct;
                                        printDaWorkout(w);
                                        break;
                                default:
                                        printDaActivity(curAct);
                                        break;
                            }
			}
                    }
                }

	}
	
	public static void printDaSchool(School activity)
	{
		System.out.println(activity.getStartTime());
		System.out.println(activity.getDate());
		System.out.println(activity.getLocation());
		System.out.println(activity.getExtraInfo());
		System.out.println(activity.getCourse());
		System.out.println(activity.getGrade());
		System.out.println(activity.getHours());
		
		String asgn[] = activity.getAssignments();
		for (int i = 0; i < asgn.length; i++)
		{
			System.out.println(asgn[i]);
		}
		
		System.out.println();
	}
	
	public static void printDaWorkout(Workout activity)
	{
		System.out.println(activity.getStartTime());
		System.out.println(activity.getDate());
		System.out.println(activity.getLocation());
		System.out.println(activity.getExtraInfo());
		String wAsgn[] = activity.getMuscles();
		for (int i = 0; i < wAsgn.length; i++)
		{
			System.out.println(wAsgn[i]);
		}
		System.out.println(activity.getCalories());
		System.out.println();
	}
	
	public static void printDaActivity(Activity activity)
	{
		System.out.println(activity.getStartTime());
		System.out.println(activity.getDate());
		System.out.println(activity.getLocation());
		System.out.println(activity.getExtraInfo());
		System.out.println();
	}
}
