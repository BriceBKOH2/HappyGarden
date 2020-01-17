package diginamic.happygarden.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

	private static final long serialVersionUID = 4316545685987523549L;
	
	public NotFoundException() {
		this.printStackTrace();
	}

	public NotFoundException(Long id) {
		System.err.println("No entries returned for id : " + id);
	}

	public NotFoundException(String msg) {
		System.err.println(msg);
	}
}
