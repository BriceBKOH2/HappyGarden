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
	 * Returns a user based on pseudonyme.
	 * 
	 * @return	UserAccount
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/pseudonyme/{pseudonyme}")
	public UserAccount findByNickname(@PathVariable String pseudonyme) throws NotFoundException {
		return service.findByNickname(pseudonyme);
	}

}
