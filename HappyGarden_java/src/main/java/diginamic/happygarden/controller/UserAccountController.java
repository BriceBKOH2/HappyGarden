package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.service.ConversationService;
import diginamic.happygarden.service.GardenService;
import diginamic.happygarden.service.UserAccountService;

@RestController
@RequestMapping("/UserAccount")
public class UserAccountController extends AbstractCRUDController<UserAccount, Long, UserAccountService> {
	
	@Autowired
	private GardenService gardenService;
	
	@Autowired
	private ConversationService convService;
	
	@Autowired
	private UserAccountService userService;
	
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
	
	@GetMapping(value = "/{id}/gardens/count")
	public Long countNbGardens(@PathVariable Long id) {
		return gardenService.countNbGardensByUserId(id);
	}
	
	@GetMapping(value = "/{id}/conversations/count")
	public Long countNbConversations(@PathVariable Long id) {
		return convService.countNbCOnversationsByUserId(id);
	}
	
	@GetMapping(value = "/{id}/friends/count")
	public Long countNbFriends(@PathVariable Long id) {
		return userService.countNbFriendsByUserId(id);
	}
}
	
	// TODO
	
//	@PutMapping("/{id}/password")
//	@PreAuthorize("hasRole('ADMIN') or @securityExpression.isConnectedUser(#id)") //Only admin or user with the same id can update the object
//	public void changePassword(@PathVariable Long id, @RequestParam String password) throws NotFoundException {
//		service.changePassword(id, password);
//	}
