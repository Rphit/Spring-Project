package com.mycompany.hibernate_mapping_demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.entity.Instructor;
import comm.example.entity.InstructorDetail;



public class App {
	public static void main(String[] args) {
		try {

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			
			session.getTransaction().begin();
			
		/*	InstructorDetail detail=new InstructorDetail();
			detail.setHobby("sleeping");
			detail.setYoutubeChannel("aaa");
			
			session.persist(detail);
			
			Instructor i=new Instructor();
			i.setFirstName("aaaa");
			i.setLastName("bbbbbb");
			i.setEmail("ccbb");
			i.setInstructorDetail(detail); */
			
			
			session.save(new Instructor(0,"John", "Doe", "john@luv2code.com", new InstructorDetail(0,"youtube.com/john", "singing")));
			
		//	session.persist(i);
			session.getTransaction().commit();
			System.out.println("inserted");
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}


