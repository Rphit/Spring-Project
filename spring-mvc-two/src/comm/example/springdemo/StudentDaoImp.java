package comm.example.springdemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImp implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StudentDaoImp() {
		super();
	}

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		String[] temp = student.getOperatingSystems();
		StringBuilder sb = new StringBuilder();
		for (String str : temp) {
			sb.append(str);
		}
		jdbcTemplate.update(
				"insert into student_mvc (first_name,last_name,country,language,oprating_system) values(?,?,?,?,?)",
				student.getFirstName(), student.getLastName(), student.getCountry(), student.getFavoriteLanguage(),
				sb.toString());
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from student_mvc", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();

				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setCountry(rs.getString("country"));
				student.setFavoriteLanguage(rs.getString("language"));
				student.setOperating(rs.getString("oprating_system"));
				return student;
			}
		});
	}

	public void getDeletebyId(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from student_mvc where id=?",id);
	}

	@Override
	public void getUpdatebyId(int id) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void getUpdatebyId(int id) {
//		// TODO Auto-generated method stub
//		jdbcTemplate.update("update employee set first_name=?,last_name=?,salary=? where employee_id=?",
//				employee.getFirstName(),employee.getLastName(),employee.getSalary(),employee.getEmployeeId());
//	}
//    
	
}
