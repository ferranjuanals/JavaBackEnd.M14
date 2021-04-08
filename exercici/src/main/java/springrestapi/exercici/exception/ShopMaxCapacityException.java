package springrestapi.exercici.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class ShopMaxCapacityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ShopMaxCapacityException(String name, int capacity) {
		super("The " + name + " shop has reached its maximum capacity (" + capacity + "/" + capacity + ")");
	}

}
