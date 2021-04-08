package springrestapi.exercici.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicateCollarException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DuplicateCollarException(String collarName, String author) {
		super("The collar '" + collarName + "' by the author '" + author + "' has been already added.");
	}

}
