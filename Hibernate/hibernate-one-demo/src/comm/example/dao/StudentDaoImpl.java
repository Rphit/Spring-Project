package comm.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.entiry.Student;

public class StudentDaoImpl implements StudentDao {
	
	private SessionFactory factory;
	private Session session; 
	
	public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		
		
		factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		 session =factory.openSession();
	}

	
	
	
	@Override
	public void createStudent(Student theStudent) {
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		session.persist(theStudent);
		session.getTransaction().commit();
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		Query query=session.createQuery("from Student");
		return query.getResultList();
	}

	@Override
	public Student getStudentById(int theId) {
		// TODO Auto-generated method stub
		Student s=session.get(Student.class, new Integer(theId)); 
		return s;
	}




	@Override
	public List<Student> getByFirstName(String theFirstName) {
		// TODO Auto-generated method stub
		Query query=session.createNamedQuery("findByFirstName").setString("fName", theFirstName);
		
		return (List<Student>) query.getResultList();
	}






}
