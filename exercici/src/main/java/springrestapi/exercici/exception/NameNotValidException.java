package springrestapi.exercici.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NameNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static String message;

	public NameNotValidException(String name) {
		super(message);
		if(StringUtils.hasText(name)) {
			message = "The name " + name + " is already taken";
		}else {
			message = "A valid name is necessary";
		}
	}
	
}
