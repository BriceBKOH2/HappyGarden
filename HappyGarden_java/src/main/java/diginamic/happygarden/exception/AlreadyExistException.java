package diginamic.happygarden.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class AlreadyExistException extends Exception {
	
	private static final long serialVersionUID = -8774110012875939875L;
	
	public AlreadyExistException() {
	}

	public AlreadyExistException(Object id) {
		super(String.format("Object with id %s already exists", id));
	}

	public AlreadyExistException(String msg) {
		super(msg);
	}
	
}
