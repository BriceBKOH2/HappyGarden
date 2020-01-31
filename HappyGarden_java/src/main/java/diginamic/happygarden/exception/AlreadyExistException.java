package diginamic.happygarden.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class AlreadyExistException extends Exception {
	
	private static final long serialVersionUID = -8774110012875939875L;

	public AlreadyExistException() {
		this.printStackTrace();
	}

	public AlreadyExistException(Object id) {
		System.err.println("Entries exist for id : " + id);
	}

	public AlreadyExistException(String msg) {
		System.err.println(msg);
	}
}
