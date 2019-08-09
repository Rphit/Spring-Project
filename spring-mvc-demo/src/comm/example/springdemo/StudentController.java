package comm.example.springdemo;

import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("student")
public class StudentController {

	@RequestMapping("/home")
	 public String showMessage()
	 {
		 return "main-page";
	 }

	 @RequestMapping("/showForm")
	 public String showform()
	 {
		 return "student-form";
	 }
	
	
}
