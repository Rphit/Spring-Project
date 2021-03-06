package comm.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import comm.example.springdemo.dao.CustomerDao;
import comm.example.springdemo.entity.Customer;
import comm.example.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao dao;
	
	@GetMapping("/list")
	public String getCustomer(Model theModel)
	{
		List<Customer> list = dao.getAllCustomer();
		theModel.addAttribute("customerList",list);
		return "customer-list";
		
	}
	
	@RequestMapping("/addcustomer")
	public String addCustomer(Model theModel)
	{
		Customer customer=new Customer();
		theModel.addAttribute("customer",customer);
		return "add-customer";
	}
	
	@RequestMapping("/processForm")
	public String add(@ModelAttribute("customer") Customer customer,Model model)
	{
	    dao.createCustomer(customer);
	    List<Customer> list = dao.getAllCustomer();
	    model.addAttribute("customerList", list);
	    return "customer-list";
	}
	

	
}
