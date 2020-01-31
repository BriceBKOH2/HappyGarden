package diginamic.happygarden.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import diginamic.happygarden.configuration.SecurityUserService;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class AlreadyExistException extends Exception {
	
	private static final long serialVersionUID = -8774110012875939875L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserService.class);
	
	public AlreadyExistException() {
		this.printStackTrace();
	}

	public AlreadyExistException(Long id) {
		LOGGER.error("Entries exist for id : " + id);
		this.printStackTrace();
	}

	public AlreadyExistException(String msg) {
		LOGGER.error(msg);
		this.printStackTrace();
	}
}
