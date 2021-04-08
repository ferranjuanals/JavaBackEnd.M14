package springrestapi.exercici.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NameNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NameNotFoundException(String name) {
		super("Name : " + name + " not found");
	}

}
