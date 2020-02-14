package diginamic.happygarden.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

	private static final long serialVersionUID = 4316545685987523549L;

	public NotFoundException() {
	}

	public NotFoundException(Object id) {
		super(String.format("Object with id %s not found", id));
	}

	public NotFoundException(String msg) {
		super(msg);
	}
}
