package comm.example.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comm.example.springdemo.entity.Customer;
import comm.example.springdemo.service.CustomerService;

public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@GetMapping("/list")
	public String getCustomer(Model theModel) {
		List<Customer> list = service.getAllCustomer();
		theModel.addAttribute("customerList", list);
		return "customer-list";
	}

}
