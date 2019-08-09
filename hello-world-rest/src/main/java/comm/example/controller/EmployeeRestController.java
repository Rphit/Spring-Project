package comm.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.example.entity.Address;
import comm.example.entity.Employee;
@RestController

@RequestMapping("/api")
public class EmployeeRestController {

	 private List<Employee> employee=null;
	 @PostConstruct
	 public void initEmployee()
	 {
		 employee =new ArrayList<Employee>();
		 employee.add(new Employee("rohit","patel",1000,new Address("indore","india")));
		 employee.add(new Employee("rohan","patel",9000,new Address("pune","india")));
		 employee.add(new Employee("rahul","patel",2000,new Address("banglore","india")));
		 employee.add(new Employee("jyoti","singh",3000,new Address("kolkata","india")));
		 employee.add(new Employee("rahul","patil",4000,new Address("bhopal","india")));
	 }
	

		@GetMapping("/employees/{theEmployee}")
		public Employee getEmployee(@PathVariable int theEmployee )
		{
			if((theEmployee>=employee.size()) ||(theEmployee<0)){
				throw new EmployeeNotFoundException("no msuch employee found with id: "+theEmployee);
				
			}
			
			
			return employee.get(theEmployee);
		}
		
		
		
		/*public List<Employee> getEmployees()
		{
			return employees;
		}*/

		@ExceptionHandler
		public ResponseEntity<EmployeeError> handleException(EmployeeNotFoundException exc)
		{
			EmployeeError error=new EmployeeError();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessge(exc.getMessage());
			error.setTimeOccured(System.currentTimeMillis());
			return new ResponseEntity<EmployeeError>(error,HttpStatus.NOT_FOUND);
		}
		
		
		
	 
	 
	 /* @GetMapping("/employees/{theEmployee}")
	 
	 public Employee getEmployee(@PathVariable int theEmployee)
	 {
		return employee.get(theEmployee);
		 
	 }
	 
	 @GetMapping("/employees")
	 public List <Employee> getEmployee()
	 {
		return  employee; 
	 }
	 
	 @Exceptionhandler
	 public ResponseEntity<EmployeeError> handleException(EmployeeNotFoundException exc)
	 {
		 EmployeeError error = new EmployeeError();
		 error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setMessage(exc.getMessage());
		 error.setTimeOccured(System.currentTimeMillis());
		 
		 return new ResponseEntity<EmployeeError>(error,HttpStatus.NOT_FOUND);
	 } */
}