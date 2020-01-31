package diginamic.happygarden.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import diginamic.happygarden.configuration.SecurityUserService;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

	private static final long serialVersionUID = 4316545685987523549L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserService.class);
	
	public NotFoundException() {
		this.printStackTrace();
	}

	public NotFoundException(Long id) {
		LOGGER.error("No entries returned for id : " + id);
		this.printStackTrace();
	}

	public NotFoundException(String msg) {
		LOGGER.error(msg);
		this.printStackTrace();
	}
}
