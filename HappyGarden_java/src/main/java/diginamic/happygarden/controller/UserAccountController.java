package diginamic.happygarden.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.service.UserAccountService;

@RestController
@RequestMapping("/UserAccount")
public class UserAccountController extends AbstractCRUDController<UserAccount, Long, UserAccountService> {

	/**
	 * Returns a user based on pseudonyme.
	 * 
	 * @return	UserAccount
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/pseudonyme/{pseudonyme}")
	public UserAccount findByPseudonyme(@PathVariable String pseudonyme) throws NotFoundException {
		return service.findByPseudonyme(pseudonyme);
	}
	
	/**
	 * Create a user in Database and return the updated user.
	 * 
	 * @return	UserAccount
	 * @throws AlreadyExistException 
	 */
	@PostMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public void save(@RequestBody UserAccount userAcc) throws AlreadyExistException {
		service.save(userAcc);
	}

}
