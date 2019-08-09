package comm.example.dao;

import java.util.List;

import comm.example.model.Employee;

public interface EmployeeDao {

	public  void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee findByEmployeeId(int employeeId);
	
	public String updateEmployeeById(int id);
}
