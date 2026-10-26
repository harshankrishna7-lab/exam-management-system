import java.util.*;
public class Exam
{
	HashMap<String,Student> students=new HashMap<>();
	ArrayList<String>subjects=new ArrayList<>();
	Scanner sc=new Scanner(System.in);

	public static void main(String[] args)
	{
		Exam e = new Exam();
		e.start();
	}
	public void start()
	{
		int choice=0;
		do 
		{
			System.out.println("\n1-Student Management ");
			System.out.println("2-Semester Examination Management");
			System.out.println("3-Result Analysis");
			System.out.println("4-Exit");
			System.out.print("Enter your Choice:");
			choice=sc.nextInt();
			sc.nextLine();
			switch (choice) 
			{
			case 1: StudentManagement(); break;
			case 2: semesterManagement(); break;
			case 3: resultAnalysis(); break;
			case 4: System.out.println("Thank You :)"); break;
			default: System.out.println("INVALID CHOICE!");
			}
		} while (choice!=4);
	}
	public void StudentManagement()
	{
		int choice=0;
		do 
		{
			System.out.println("\n1-Add Student");
			System.out.println("2-View Students");
			System.out.println("3-Search Student");
			System.out.println("4-Update Student");
			System.out.println("5-Delete Student");
			System.out.println("6-Previous Page");
			System.out.print("Enter Your Choice:");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
			case 1: addStudent(); break;
			case 2: viewStudent(); break;
			case 3: searchStudent(); break;
			case 4: updateStudent(); break;
			case 5: delete(); break;
			case 6: System.out.println("OK"); break;
			default: System.out.println("INVALID CHOICE");
			}
		} while (choice!=6);
	}

	public void addStudent()
	{
		System.out.print("Enter Student ID: ");
		String id=sc.nextLine();
		if (students.containsKey(id))
		{
			System.out.println("ID already exists!");
			return;
		}
		System.out.print("Enter Student Name: ");
		String name=sc.nextLine();
		System.out.print("Enter Student Department: ");
		String dept=sc.nextLine();
		System.out.print("Enter Student Year(1-4): ");
		int year=sc.nextInt();
		sc.nextLine();
		if (year<1||year>4)
		{
			System.out.println("INVALID ENTRY:");
			return;
		}
		students.put(id,new Student(id,name,dept, year));
		System.out.println("Student Record registered Successfully!");
	}

	public void viewStudent()
	{
		if (students.isEmpty())
		{
			System.out.println("No students found.");
			return;
		}
		System.out.printf("%-8s %-12s %-10s %-5s%n", "ID", "Name", "Dept", "Year");
		System.out.println("-------------------------------------------");
		for (Student s : students.values())
		{
			System.out.printf("%-8s %-12s %-10s %-5d%n",
				s.getID(), s.getName(), s.getDept(), s.getYear());
		}
	}

	public void searchStudent()
	{
		System.out.print("Enter Student  ID: ");
		String id=sc.nextLine();
		Student s=students.get(id);
		if (s==null)
		{
			System.out.println("Not Found!");
			return;
		}
		System.out.println("ID : " +s.getID());
		System.out.println("Name : " +s.getName());
		System.out.println("Department : " +s.getDept());
		System.out.println("Year : " +s.getYear());
	}

	public void updateStudent()
	{
		System.out.print("Enter the ID of the student who needed to be updated :");
		String id=sc.nextLine();
		Student s=students.get(id);
		if (s==null)
		{
			System.out.println("Not Found!");
			return;
		}
		System.out.print("Enter updated Student Name: ");
		String name=sc.nextLine();
		System.out.print("Enter Student updated Department: ");
		String dept=sc.nextLine();
		System.out.print("Enter Student updated  Year(1-4): ");
		int year=sc.nextInt();
		sc.nextLine();
		if (year<1||year>4)
		{
			System.out.println("INVALID ENTRY:");
			return;
		}
		s.setName(name);
		s.setDept(dept);
		s.setYear(year);
		System.out.println("Updated!");
	}

	public void delete()
	{
		System.out.print("Enter ID to remove it :");
		String id=sc.nextLine();
		if (students.remove(id)!=null)
		{
			System.out.println("Removed!");
		}
		else
		{
			System.out.println("Not Found!");
		}
	}

	public void semesterManagement()
	{
		int choice=0;
		do
		{
			System.out.println("\n1-Add subject");
			System.out.println("2-Enter Marks");
			System.out.println("3-Update marks");
			System.out.println("4-View marks");
			System.out.println("5-Previous page");
			System.out.print("Enter Your Choice:");
			choice=sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
			case 1: addSub(); break;
			case 2: marks(); break;
			case 3: Updatemarks(); break;
			case 4: viewmarks(); break;
			case 5: System.out.println("OK"); break;
			default: System.out.println("INVALID INPUT!");
			}
		} while (choice!=5);
	}

	public void addSub()
	{
		System.out.print("Enter Subject Name: ");
		String sub=sc.nextLine().trim().toUpperCase();
		if (subjects.contains(sub))
		{
			System.out.println("Subject already exists!");
			return;
		}
		subjects.add(sub);
		System.out.println("Subject added!");
	}

	public void marks()
	{
		System.out.print("Enter Student ID: ");
		String id=sc.nextLine();
		Student s=students.get(id);
		if (s==null)
		{
			System.out.println("Student not found!");
			return;
		}
		System.out.println("Subjects: " + subjects);
		System.out.print("Enter Subject: ");
		String sub = sc.nextLine().trim().toUpperCase();
		if (!subjects.contains(sub))
		{
			System.out.println("Subject not found!");
			return;
		}
		if (s.hasMark(sub))
		{
			System.out.println("Marks already entered. Use Update marks.");
			return;
		}
		System.out.print("Enter Marks (0-100): ");
		int m=sc.nextInt();
		sc.nextLine();
		if (m<0||m> 100)
		{
			System.out.println("Marks must be between 0 and 100.");
			return;
		}
		s.setMark(sub,m);
		System.out.println("Marks saved!");
	}

	public void Updatemarks()
	{
		System.out.print("Enter Student ID: ");
		String id=sc.nextLine();
		Student s=students.get(id);
		if (s==null)
		{
			System.out.println("Student not found!");
			return;
		}
		System.out.print("Enter Subject: ");
		String sub = sc.nextLine().trim().toUpperCase();
		if (!s.hasMark(sub))
		{
			System.out.println("No marks entered for this subject yet.");
			return;
		}
		System.out.print("Enter New Marks (0-100): ");
		int m = sc.nextInt();
		sc.nextLine();
		if (m < 0 || m > 100)
		{
			System.out.println("Marks must be between 0 and 100.");
			return;
		}
		s.setMark(sub,m);
		System.out.println("Marks updated!");
	}

	public void viewmarks()
	{
		System.out.print("Enter Student ID: ");
		String id=sc.nextLine();
		Student s=students.get(id);
		if (s==null)
		{
			System.out.println("Student not found!");
			return;
		}
		if (!s.hasMarks())
		{
			System.out.println("No marks entered yet.");
			return;
		}
		System.out.println("------ Marks of " + s.getName() + " (" + s.getID() + ") ------");
		System.out.printf("%-15s %-6s%n", "Subject", "Marks");
		for (Map.Entry<String, Integer> e : s.getMarks().entrySet())
		{
			System.out.printf("%-15s %-6d%n", e.getKey(), e.getValue());
		}
		System.out.println("-----------------------------");
		System.out.println("Total   : " + s.getTotal());
		System.out.printf("Average : %.2f%n", s.getAverage());
		System.out.println("Grade   : " + s.getGrade());
		System.out.println("Result  : " + (s.isPass() ? "PASS" : "FAIL"));
	}
	public void resultAnalysis()
	{
		int choice = 0;
		do
		{
			System.out.println("\n1-Assign Grades");
			System.out.println("2-Pass/Fail Students");
			System.out.println("3-Class Topper");
			System.out.println("4-Pass Percentage");
			System.out.println("5-Sort Students by Marks");
			System.out.println("6-Previous page");
			System.out.print("Enter Your Choice:");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
			case 1: assignGrades(); break;
			case 2: passFail(); break;
			case 3: topper(); break;
			case 4: passPercentage(); break;
			case 5: sortStudents(); break;
			case 6: System.out.println("OK"); break;
			default: System.out.println("INVALID INPUT!");
			}
		} while (choice!=6);
	}

	public void assignGrades()
	{
		System.out.printf("%-8s %-12s %-8s %-8s %-6s%n", "ID", "Name", "Total", "Average", "Grade");
		System.out.println("------------------------------------------------");
		for (Student s : students.values())
		{
			if (s.hasMarks())
			{
				System.out.printf("%-8s %-12s %-8d %-8.2f %-6s%n",
					s.getID(), s.getName(), s.getTotal(), s.getAverage(), s.getGrade());
			}
		}
	}

	public void passFail()
	{
		System.out.println("--- PASSED ---");
		for (Student s : students.values())
		{
			if (s.hasMarks() && s.isPass())
			{
				System.out.println(s.getID() + " | " + s.getName());
			}
		}
		System.out.println("--- FAILED ---");
		for (Student s : students.values())
		{
			if (s.hasMarks() && !s.isPass())
			{
				System.out.println(s.getID() + " | " + s.getName());
			}
		}
	}

	public void topper()
	{
		Student top=null;
		for (Student s : students.values())
		{
			if (s.hasMarks()&&(top==null||s.getTotal()>top.getTotal()))
			{
				top=s;
			}
		}
		if (top==null)
		{
			System.out.println("No marks entered yet.");
			return;
		}
		System.out.println("Class Topper : " + top.getName() + " (" + top.getID() + ")");
		System.out.println("Total        : " + top.getTotal());
		System.out.printf("Average      : %.2f%n", top.getAverage());
	}

	public void passPercentage()
	{
		int count=0;
		int passed=0;
		for (Student s : students.values())
		{
			if (s.hasMarks())
			{
				count++;
				if (s.isPass())
				{
					passed++;
				}
			}
		}
		if (count==0)
		{
			System.out.println("No marks entered yet.");
			return;
		}
		System.out.println("Passed : " + passed + " of " + count);
		System.out.printf("Pass percentage : %.2f%%%n", passed * 100.0 / count);
	}

	public void sortStudents()
	{
	    ArrayList<Student> list=new ArrayList<>();

	    for (Student s : students.values())
	    {
	        if (s.hasMarks())
	        {
	            list.add(s);
	        }
	    }

	    for (int i=0;i<list.size()-1;i++)
	    {
	        for (int j=0;j<list.size()-1-i;j++)
	        {
	            if (list.get(j).getTotal() < list.get(j + 1).getTotal())
	            {
	                Student temp=list.get(j);
	                list.set(j,list.get(j + 1));
	                list.set(j+1,temp);
	            }
	        }
	    }

	    System.out.printf("%-6s %-8s %-12s %-8s%n",
	                      "Rank", "ID", "Name", "Total");

	    System.out.println("----------------------------------------");

	    int rank=1;

	    for (Student s : list)
	    {
	        System.out.printf("%-6d %-8s %-12s %-8d%n",
	                          rank, s.getID(), s.getName(), s.getTotal());

	        rank++;
	    }
	}
}