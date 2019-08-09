package comm.example.dao;

import java.util.List;


import comm.example.entiry.Student;

public interface StudentDao {
	
	public void createStudent( Student theStudent);
	public List<Student> getAllStudent();
    public Student getStudentById( int theId);
    public List<Student> getByFirstName( String theFirstName);
}
