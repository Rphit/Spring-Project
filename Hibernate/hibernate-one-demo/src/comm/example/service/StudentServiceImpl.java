package comm.example.service;

import java.util.List;

import comm.example.dao.StudentDao;
import comm.example.dao.StudentDaoImpl;
import comm.example.entiry.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao;
	
	
	
	public StudentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		dao=new StudentDaoImpl();
	}

	@Override
	public void createStudent(Student theStudent) {
		// TODO Auto-generated method stub
		dao.createStudent(theStudent);
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	@Override
	public Student getStudentById(int theId) {
		// TODO Auto-generated method stub
		return dao.getStudentById(theId);
	}

	public List<Student> getByFirstName(String theFirstName) {
		// TODO Auto-generated method stub
		return dao.getByFirstName(theFirstName);
	}

	
}
