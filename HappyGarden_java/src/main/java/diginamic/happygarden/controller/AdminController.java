package diginamic.happygarden.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.service.UserAccountService;
import diginamic.happygarden.service.UserRightService;
import diginamic.happygarden.service.UserRoleService;

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
	 * Instanciate database with rights, roles, admin and basic user
	 * @return
	 */
	@RequestMapping(value ="/initiateDB", method=RequestMethod.GET)
	@EventListener(ApplicationReadyEvent.class)
	public List<UserAccount> intiateDB() {
		List<UserRight> userRightsBasic = new ArrayList<UserRight>();
		UserRight userRight = new UserRight("comment");
		userRightsBasic.add(userRight);
		userRight = new UserRight("message");
		userRightsBasic.add(userRight);
		
		/* Saving user rights in DataBase */
		userRightServ.saveAll(userRightsBasic);

		/* Saving role basic for regular users in DataBase*/
		UserRole userRoleBasic = new UserRole("basic",userRightsBasic);
		userRoleServ.save(userRoleBasic);
		
		List<UserRight> userRightsAdmin = new ArrayList<UserRight>();
		userRight = new UserRight("account_suppression");
		userRightsAdmin.add(userRight);
		userRight = new UserRight("account_addition");
		userRightsAdmin.add(userRight);
		userRight = new UserRight("account_modification");
		userRightsAdmin.add(userRight);
		userRight = new UserRight("plant_suppresion");
		userRightsAdmin.add(userRight);
		userRight = new UserRight("plant_addition");
		userRightsAdmin.add(userRight);
		userRight = new UserRight("plant_modification");
		userRightsAdmin.add(userRight);
		
		/* Saving admin rights in DataBase */
		userRightServ.saveAll(userRightsAdmin);
		
		/* Saving role admin for regular users in DataBase*/
		userRightsAdmin.addAll(userRightsBasic);
		UserRole userRoleAdmin = new UserRole("admin",userRightsAdmin);
		userRoleServ.save(userRoleAdmin);
		
		/* Saving a admin user in DataBase*/
		UserAccount userAccAdmin = new UserAccount("admin", "admin", "admin",userRoleServ.findByName("admin").get());
		userAccAdmin.setPassword("admin");
		userAccServ.save(userAccAdmin);
		
		/* Saving a basic user in DataBase*/
		UserAccount userAccBasic = new UserAccount("testFirstName", "testLastName", "testPseudonyme",userRoleServ.findByName("basic").get());
		userAccBasic.setPassword("testPassword");
		userAccServ.save(userAccBasic);
		
		return userAccServ.findAll();
	}
}
