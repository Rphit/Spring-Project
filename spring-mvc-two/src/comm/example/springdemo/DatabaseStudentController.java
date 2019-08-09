package comm.example.springdemo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/database")
public class DatabaseStudentController {
	@Autowired
	private StudentDao dao;
	
	/*
	 * @PostConstruct public void init() { ClassPathXmlApplicationContext
	 * context=new ClassPathXmlApplicationContext(
	 * 
	 * "spring-mvc-demo-servlet"); dao=context.getBean("dao",StudentDao.class); }
	 */
	
	
	
	@RequestMapping("/showForm")
	public String showPage( Model theModel)
	
	{
		Student student=new Student();
		theModel.addAttribute("student",student);
		
		return "student-form";
	}
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		dao.createStudent(student);
		
		return "redirect:/database/displayAll";
	}
	
	@RequestMapping("/displayAll")
	public String getAllStudent(Model theModel)
	
	{
		List<Student> l=dao.getAll();
		theModel.addAttribute("list",l);
		return "students";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteById(@PathVariable int id)
	
	{
		dao.getDeletebyId(id);
		return "redirect:/database/displayAll";
   
    }
	

	@RequestMapping("/update/{id}")
	public String updateById(@PathVariable int id)
	
	{
		dao.getUpdatebyId(id);
		return "redirect:/database/displayAll";
   
    }
}