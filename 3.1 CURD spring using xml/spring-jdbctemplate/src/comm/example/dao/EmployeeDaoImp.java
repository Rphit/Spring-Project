package comm.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import comm.example.model.Employee;

public class EmployeeDaoImp  implements EmployeeDao{
	
	private JdbcTemplate jdbcTemplate;
 	
	
	
	
	public EmployeeDaoImp() {
		super();
	
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into employee values(?,?,?,?)",employee.getEmployeeId(),
				employee.getFirstName(),employee.getLastName(),employee.getSalary());
		
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from employee", new RowMapper<Employee>(){
			
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Employee employee=new Employee();
			employee.setEmployeeId(rs.getInt(1));
			employee.setFirstName(rs.getString(2));
			employee.setLastName(rs.getString(3));
			employee.setSalary(rs.getInt(4));
			return employee;
		}		
	});
	}


	@Override
	public Employee findByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from employee where employee_id=? ",
				new RowMapper<Employee>(){
			
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Employee employee=new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setSalary(rs.getInt(4));
				return employee;
			}		
		},employeeId);
	}

	static Scanner sc=new Scanner(System.in);
	@Override
	public String updateEmployeeById(int id) {
		
		System.out.println("first name--");
		String fName=sc.next();
		System.out.println("last name--");
		String lName=sc.next();
		System.out.println("salary --");
		int salary=sc.nextInt();
		
		Employee employee = new Employee(id,fName,lName,salary);
		jdbcTemplate.update("update employee set first_name=?,last_name=?,salary=? where employee_id=?",
				employee.getFirstName(),employee.getLastName(),employee.getSalary(),employee.getEmployeeId());
		

		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
			
	


