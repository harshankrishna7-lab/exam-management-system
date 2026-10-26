import java.util.*;

public class Student
{
	private String id;
	private String name;
	private String dept;
	private int year;
	private HashMap<String,Integer>marks=new HashMap<>();   // subject -> marks

	public Student(String id,String name,String dept,int year)
	{
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.year=year;
	}

	public String getID()
	{
		return id; 
		}
	public String getName()
	{ 
		return name; 
	}
	public String getDept() 
	{ 
		return dept;
	}
	public int getYear() 
	{ return year; 
	}

	public void setName(String name) 
	{ this.name = name; 
	}
	public void setDept(String dept) 
	{ this.dept = dept; 
	}
	public void setYear(int year) 
	{ this.year = year; 
	}

	public HashMap<String, Integer> getMarks() 
	{ return marks; 
	}
	public void setMark(String subject, int m) 
	{ marks.put(subject, m); 
	}
	public boolean hasMark(String subject) 
	{ return marks.containsKey(subject); 
	}
	public boolean hasMarks() 
	{ return !marks.isEmpty();
	}

	public int getTotal()
	{
		int total=0;
		for (int m : marks.values())
		{
			total=total+m;
		}
		return total;
	}

	public double getAverage()
	{
		if (marks.isEmpty())
		{
			return 0;
		}
		return getTotal()/(double)marks.size();
	}

	public boolean isPass()
	{
		if (marks.isEmpty())
		{
			return false;
		}
		for (int m : marks.values())
		{
			if (m<40)
			{
				return false;
			}
		}
		return true;
	}

	public String getGrade()
	{
		if (!isPass())
		{
			return "F";
		}
		double avg=getAverage();
		if (avg>=90) 
		return "A";
		else if (avg>=75) 
		return "B";
		else if (avg>=60)
		return "C";
		else
		return "D";
	}
}