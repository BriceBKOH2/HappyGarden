package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.service.GardenService;
import diginamic.happygarden.service.UserAccountService;

@RestController
@RequestMapping("/UserAccount")
public class UserAccountController extends AbstractCRUDController<UserAccount, Long, UserAccountService> {
	
	@Autowired
	private GardenService gardenService;
	
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
	
	
	@GetMapping(value = "/{id}/gardens")
	public List<Garden> findGardensByUserId(@PathVariable Long id) throws NotFoundException {
		return gardenService.findByUserId(id);
	}
	
	@GetMapping("/search")
	public List<UserAccount> searchByName(@RequestParam("name") String name) {
		return service.findByFirstnameIgnoreCaseContainsOrLastnameIgnoreCaseContainsOrNicknameIgnoreCaseContains(name);
	}
	
	@PreAuthorize("hasAuthority('" + UserRight.RIGHT_ADMINISTRATION + "')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/{id}/password")
	@PreAuthorize("hasRole('ADMIN') or @securityExpression.isConnectedUser(#id)") //Only admin or user with the same id can update the object
	public void changePassword(@PathVariable Long id, @RequestParam String password) throws NotFoundException {
		UserAccount user = service.findById(id);
		service.changePassword(user, password);
	}
	
}
