package comm.example.springdemo.errorhandler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.example.springdemo.entity.Customer;
import comm.example.springdemo.service.CustomerService;



@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private List<Customer> cust = null;

	@Autowired
	private CustomerService service;
	
	

	

	@GetMapping("/customers")
	public List<Customer> getAll() {
		
		return service.getAllCustomers();
		
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = service.getCustomer(id);

		if (customer == null) {
			throw new IdNotFoundException("no such customer found with id: " + id);
		}

		return customer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {

		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update

		theCustomer.setId(0);

		service.saveCustomer(theCustomer);

		return theCustomer;
	}

	// add mapping for PUT /customers - update existing customer

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {

		service.saveCustomer(theCustomer);

		return theCustomer;

	}

	// add mapping for DELETE /customers/{customerId} - delete customer

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		Customer tempCustomer = service.getCustomer(customerId);

		service.deleteCustomer(customerId);

		return "Deleted customer id - " + customerId;
	}

}
