package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class UserAccountController {

	@Autowired
	private UserAccountService userAccServ;

	/**
	 * Returns a list of all users.
	 * 
	 * @return List<UserAccount>
	 */
	@GetMapping
	public List<UserAccount> findAll() {
		return userAccServ.findAll();
	}

	/**
	 * Returns a user based on id.
	 * 
	 * @return	UserAccount
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/{id}")
	public UserAccount findById(@PathVariable Long id) throws NotFoundException {
		return userAccServ.findById(id);
	}
	

	/**
	 * Returns a user based on pseudonyme.
	 * 
	 * @return	UserAccount
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/pseudonyme/{pseudonyme}")
	public UserAccount findByPseudonyme(@PathVariable String pseudonyme) throws NotFoundException {
		return userAccServ.findByPseudonyme(pseudonyme);
	}
	
	/**
	 * Create a user in Database and return the updated user.
	 * 
	 * @return	UserAccount
	 * @throws AlreadyExistException 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserAccount save(@RequestBody UserAccount userAcc) throws AlreadyExistException {
		return userAccServ.save(userAcc);
	}
	
	/**
	 * Update a user in Database and return it.
	 * 
	 * @return	UserAccount
	 * @throws NotFoundException 
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserAccount update(@RequestBody UserAccount userAcc) throws NotFoundException {
		return userAccServ.update(userAcc);
	}
	
	/**
	 * Delete a user in Database.
	 */
	@PreAuthorize("account_suppression")
	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@RequestBody UserAccount userAcc) {
		userAccServ.delete(userAcc);
	}
}
