package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.service.ConversationService;
import diginamic.happygarden.service.GardenService;
import diginamic.happygarden.service.UserAccountService;

/** 
 * Controller should always send back UserAcccount object without the password
 * for security reasons !
 * @author Brice B
 *
 */
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
	 * @param String
	 * @return	UserAccount
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/nickname/{nickname}")
	public UserAccount findByNickname(@PathVariable String nickname) throws NotFoundException {
		UserAccount user = service.findByNickname(nickname);
		user.setPassword(null);
		return user;
	}
	
	@GetMapping("/friends/{id}")
	public List<UserAccount> findAllFriendsByUserId(@PathVariable Long id) {
		return service.findAllFriendsByUserId(id);
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
	
	@GetMapping("/search")
	public List<UserAccount> searchByName(@RequestParam("name") String name) {
		List<UserAccount> users = service.findByFirstnameIgnoreCaseContainsOrLastnameIgnoreCaseContainsOrNicknameIgnoreCaseContains(name);
		for (UserAccount user : users) {
			user.setPassword(null);
		}
		return users;
	}
	
	@Override
	@PreAuthorize("permitAll()")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public UserAccount save(@RequestBody UserAccount entity) throws AlreadyExistException {
		entity = service.save(entity);
		entity.setPassword(null);
		return entity;
	}
	
	/**
	 * Returns the UserAccount after updating the Database with the entity retrieve from request body.
	 * Before updating entity, it sets its password from the one saved in Database then send the update.
	 * Before returning entity, it sets its password to null.
	 * @body UserAccount
	 * @return UserAccount
	 */
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserAccount update(@RequestBody UserAccount entity) throws NotFoundException {
		entity.setPassword(service.findById(entity.getId()).getPassword());
		service.update(entity);
		entity.setPassword(null);
		return entity;
	}
	
	/**
	 * Change password of UserAccount based on @param id, only avaible
	 * for admin or UserAccount authenticated with same id as @param id
	 * @param id
	 * @param password
	 * @throws NotFoundException
	 */
	@PutMapping("/{id}/password")
	@PreAuthorize("hasRole('ADMIN') or @securityExpression.isConnectedUser(#id)") //Only admin or user with the same id can update the object
	public void changePassword(@PathVariable Long id, @RequestParam String password) throws NotFoundException {
		UserAccount user = service.findById(id);
		service.changePassword(user, password);
	}
	
	/**
	 * Delete UserAccount in Database based on its id
	 * @param id
	 */
	@PreAuthorize("hasAuthority('" + UserRight.RIGHT_ADMINISTRATION + "')")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	
}
