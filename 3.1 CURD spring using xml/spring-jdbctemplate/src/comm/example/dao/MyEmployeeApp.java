package comm.example.dao;
import java.util.*;
import java.util.Scanner;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import comm.example.model.Employee;

public class MyEmployeeApp {
 
	 static Scanner sc=new Scanner(System.in);
	
	public static void main(String args[])
	{
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

		int choice1;
		EmployeeDao dao=context.getBean("eDao",EmployeeDao.class);
		
		do {
			System.out.println("1  Add employee");
			System.out.println("2  find employee by id");
			System.out.println("3  Display All employee");
			System.out.println("4  update employee by id");
			System.out.println("0  Exit employee");
			System.out.println("input your choice");
			choice1=sc.nextInt();
			switch(choice1)
			{
			case 1:	
					
		
		System.out.println("ID --");
		int id=sc.nextInt();
		System.out.println("first name--");
		String fName=sc.next();
		System.out.println("last name--");
		String lName=sc.next();
		System.out.println("salary --");
		int salary=sc.nextInt();
		
		dao.addEmployee(new Employee(id,fName,lName,salary));
		System.out.println("success");
		  
		break;
		
			case 2:
				
				System.out.println("ID --");
				int id1=sc.nextInt();
				
				Employee employee=dao.findByEmployeeId(id1);
				if(employee !=null)
					System.out.println(employee.toString());
				
		   break;
		   
			case 3:
		List<Employee> list=dao.getAllEmployees();
		 for(Employee e:list)
		 {
		   System.out.println(e);	 
		 }
		 break;
			case 0:
				System.exit(0);
				System.out.println("byee!!!");
		 break;
		 
			case 4:
				System.out.println("enter ID fro update");
				int id2=sc.nextInt();
				
				Employee employee1=dao.findByEmployeeId(id2);
				if(employee1 !=null)
				{	dao.updateEmployeeById(id2);
				System.out.println("employee updated ");}
				else
					System.out.println("no employee id found ");
				
		   break;
				
		 
		default:
		break;
	}
		}while(choice1!=0);
	
	
	
	}

}

	

