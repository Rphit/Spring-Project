package comm.example.springdemo.errorhandler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerError> handleException(IdNotFoundException exc)
	{
		
	 CustomerError error= new CustomerError(HttpStatus.NOT_FOUND.value(),
	 
	 exc.getMessage(),System.currentTimeMillis());
	return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler
	public ResponseEntity<CustomerError> handleException(Exception e)
	{
		
	 CustomerError error= new CustomerError(HttpStatus.NOT_FOUND.value(),
	 
	 e.getMessage(),System.currentTimeMillis());
	return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
}
