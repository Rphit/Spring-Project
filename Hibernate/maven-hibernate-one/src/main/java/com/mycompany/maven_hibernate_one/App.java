
	package com.mycompany.maven_hibernate_one;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

	import comm.example.entity.Student;

	/**
	 * Hello world!
	 *
	 */
	public class App 
	{
	    public static void main( String[] args )
	    {
	        try {
	        	
	        	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
	        			addAnnotatedClass(Student.class).buildSessionFactory();
	        	Session session=factory.openSession();
	        	Student student=session.get(Student.class, 2);
	        /*	if(student!=null)
	        	{
	        		
	        		session.getTransaction().begin();
	        		session.delete(student);
	        		
	        		session.getTransaction().commit();
	        		System.out.println("record deleted");
	        	}*/
	        	
	        	student.setFirstName("richa");
	        	student.setLastName("singh");
                student.setEmail("richa@gmail.com");
                session.getTransaction().begin();
         		session.merge(student);
                session.getTransaction().commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	}

