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
	}}
