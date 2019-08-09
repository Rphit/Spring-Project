package comm.example.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeNotFoundException extends RuntimeException {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException( CustomerNotFound exc )
	{
		
		CustomerErrorResponce 
		
	}
	

}
