package comm.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
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
		 employee.add(new Employee("rohan","patel",1000,new Address("pune","india")));
		 employee.add(new Employee("rahul","patel",1000,new Address("banglore","india")));
	 }
	 @GetMapping("/employees")
	 public List <Employee> getEmployee()
	 {
		return  employee; 
	 }
}