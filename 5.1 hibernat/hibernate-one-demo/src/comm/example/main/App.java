package comm.example.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.entiry.Student;

public class App {

	public static void main(String[] args)
	{
		
		try
		{
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
					buildSessionFactory();
			
			Session session =factory.openSession();
			
			session.getTransaction().begin();
			session.save( new Student("rahul","patel","rohit@gmail.com") );
			session.getTransaction().commit();
			System.out.println("row inserted");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
}
