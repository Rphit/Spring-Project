package comm.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
@GetMapping("/")
public String sayHello()
{
	return "hello worldin rest api";
}


}