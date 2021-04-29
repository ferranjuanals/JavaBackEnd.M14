package springrestapi.exercici.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicateCollarException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static String message;
	
	public DuplicateCollarException(String collarName, String author) {
		super(message);
		if(StringUtils.hasText(author)) {
			message = "The collar '" + collarName + "' by the author '" + author + "' has been already added";
		}else {
			message = "The collar '" + collarName + "' by an anonymous author has been already added";
		}
	}

}
