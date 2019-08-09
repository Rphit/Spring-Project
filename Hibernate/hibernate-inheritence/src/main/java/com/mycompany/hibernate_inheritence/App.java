package com.mycompany.hibernate_inheritence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	try
    	{
    		
    		
    		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(Car.class).addAnnotatedClass(Automatic.class).addAnnotatedClass(Manual.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			
			session.getTransaction().begin();
			Car c=new Car();
			c.setCarColor("white");
			c.setMakeYear("2019");
			session.save(c);
			
			Automatic a=new Automatic();
			a.setCarColor("blue");
			a.setMakeYear("2019");
			a.setIsAutomatic("true");
			session.save(a);
			
    		Manual c1=new Manual();
    		c1.setCarColor("red");
    		c1.setMakeYear("2019");
    		c1.setIsAutomatic("false");
    		session.save(c1);
    		session.getTransaction().commit();
    		System.out.println("done");
    		
    	} catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    
    
    
    }
    
    
    
}
