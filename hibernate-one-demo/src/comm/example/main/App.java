package comm.example.main;




import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.err;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.entiry.Student;
import comm.example.service.StudentService;
import comm.example.service.StudentServiceImpl;

public class App {

	

	public static void main(String[] args)
	{
		Scanner sc= new Scanner(in);
		 StudentService service= new StudentServiceImpl();
		try
		{
			int choice;
			
			do
			{
				out.println("1 enter the student detail ");
				out.println("2 display detail ");
				out.println("3 search by id ");
				out.println("4 search by name ");
				out.println("0 exit");
		choice=sc.nextInt();	
				
			
			switch(choice)
			{
			case 1:
				out.print("first name");
			    String firstName=sc.next();
			    
			    out.print("last name");
			    String lastName=sc.next();
			   
			    out.print("email");
			    String email=sc.next();
			    
			    service.createStudent(new Student(firstName,lastName,email));
			    out.print("inserted data");
			    break;
			    
			case 2:
				List<Student> list=service.getAllStudent();
			    for(Student s:list)
			    {
			    	out.print(s);
			    }
			    break;
			    
			case 3:
				out.print("search by id");
				int theId=sc.nextInt();
				Student s=service.getStudentById(theId);
				if(s!=null)
				{
					out.print("found"+s);
				}else
				{out.print("id not found ");}
				
			case 4:
				out.println(" search by name enter ");
				String theFirstName=sc.next();
				List<Student> list1=service.getByFirstName(theFirstName);
				for(Student s1:list1)
				{
					out.print(s1);
				}
				
			case 0:
				out.println("byee");
				System.exit(0);
				
			}
			    
			}while(choice!=0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
}
