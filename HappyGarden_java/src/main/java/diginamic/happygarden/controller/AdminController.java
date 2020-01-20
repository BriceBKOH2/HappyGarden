package diginamic.happygarden.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.service.UserAccountService;
import diginamic.happygarden.service.UserRightService;
import diginamic.happygarden.service.UserRoleService;

//@PreAuthorize("admnistration")
@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private UserRightService userRightServ;
	
	@Autowired
	private UserRoleService userRoleServ;
	
	@Autowired
	private UserAccountService userAccServ;
	
	/**
	 * Instantiate database with rights, roles, admin and basic user
	 * @return
	 * @throws AlreadyExistException entity already exist in database
	 * @throws NotFoundException entity doesn't exist in database
	 */
	@GetMapping(value ="/initiateDB")
	@EventListener(ApplicationReadyEvent.class)
	public List<UserAccount> intiateDB() throws NotFoundException, AlreadyExistException {
		try {
			userRoleServ.findByName("basic");
		}
		catch (NotFoundException e) {
			List<UserRight> userRightsBasic = new ArrayList<UserRight>();
			UserRight userRightBasic = new UserRight("comment");
			userRightsBasic.add(userRightBasic);
			userRightBasic = new UserRight("message");
			userRightsBasic.add(userRightBasic);
			
			/* Saving user rights in DataBase */
			userRightServ.saveAll(userRightsBasic);

			/* Saving role basic for regular users in DataBase*/
			UserRole userRoleBasic = new UserRole("basic", userRightsBasic);
			userRoleServ.save(userRoleBasic);
		}
		
		try {
			userRoleServ.findByName("admin");
		}
		catch (NotFoundException e) {
			List<UserRight> userRightsAdmin = new ArrayList<UserRight>();
			UserRight userRightAdmin = new UserRight("administration");
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight("account_suppression");
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight("plant_suppresion");
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight("plant_addition");
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight("plant_modification");
			userRightsAdmin.add(userRightAdmin);
			
			/* Saving admin rights in DataBase */
			userRightServ.saveAll(userRightsAdmin);
			
			/* Saving role admin for regular users in DataBase*/
			userRightsAdmin.addAll(userRoleServ.findByName("basic").getUserRights());
			UserRole userRoleAdmin = new UserRole("admin",userRightsAdmin);
			userRoleServ.save(userRoleAdmin);
		}
		
		try {
			userAccServ.findByPseudonyme("admin");
		}
		catch (NotFoundException e) {
			/* Saving a admin user in DataBase*/
			UserAccount userAccAdmin = new UserAccount("admin", "admin", "admin",userRoleServ.findByName("admin"));
			userAccAdmin.setPassword("admin");
			userAccServ.save(userAccAdmin);
		}
		
		try {
			userAccServ.findByPseudonyme("testPseudonyme");
		}
		catch (NotFoundException e) {
			/* Saving a basic user in DataBase*/
			UserAccount userAccBasic = new UserAccount("testFirstName", "testLastName", "testPseudonyme", userRoleServ.findByName("basic"));
			userAccBasic.setPassword("testPassword");
			userAccServ.save(userAccBasic);
		}
		
		return userAccServ.findAll();
	}
}
