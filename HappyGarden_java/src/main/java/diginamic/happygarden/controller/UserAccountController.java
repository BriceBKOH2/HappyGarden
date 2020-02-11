package diginamic.happygarden.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.service.UserAccountService;

@RestController
@RequestMapping("/UserAccount")
public class UserAccountController extends AbstractCRUDController<UserAccount, Long, UserAccountService> {
	
	
	/**
	 * Returns a user based on nickname.
	 * 
	 * @return	UserAccount
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/nickname/{nickname}")
	public UserAccount findByNickname(@PathVariable String nickname) throws NotFoundException {
		return service.findByNickname(nickname);
	}
	
	// TODO
	
//	@PutMapping("/{id}/password")
//	@PreAuthorize("hasRole('ADMIN') or @securityExpression.isConnectedUser(#id)") //Only admin or user with the same id can update the object
//	public void changePassword(@PathVariable Long id, @RequestParam String password) throws NotFoundException {
//		service.changePassword(id, password);
//	}

}
