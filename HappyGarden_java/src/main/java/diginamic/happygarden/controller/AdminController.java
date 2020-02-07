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
import diginamic.happygarden.service.UserRoleService;//@PreAuthorize("admnistration")

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	//TODO : changer de place ces constantes > entity ou enum
	/* Role Constant */

	public static final String BASIC = "Basic";
	public static final String ADMIN = "Admin";
	
	/* Right Constant */
	public static final String RIGHT_COMMENT = "Comment";
	public static final String RIGHT_MESSAGE = "Message";
	public static final String RIGHT_ADMINISTRATION = "administration";
	public static final String RIGHT_ACCOUNT_SUPPRESION = "account_suppression";
	public static final String RIGHT_PLANT_SUPPRESSION = "plant_suppression";
	public static final String RIGHT_PLANT_ADDITION = "plant_addition";
	public static final String RIGHT_PLANT_MODIFICATION = "plant_modification";
	
	@Autowired
	private UserRightService userRightServ;
	
	@Autowired
	private UserRoleService userRoleServ;
	
	@Autowired
	private UserAccountService userAccServ;

	/**
	 * Instantiate database with rights, roles, admin and basic user
	 * 
	 * @return
	 * @throws AlreadyExistException entity already exist in database
	 * @throws NotFoundException     entity doesn't exist in database
	 */
	@GetMapping(value = "/initiateDB")
	@EventListener(ApplicationReadyEvent.class)
	public List<UserAccount> intiateDB() throws NotFoundException, AlreadyExistException {
		try {
			userRoleServ.findByName(BASIC);
		} catch (NotFoundException e) {
			List<UserRight> userRightsBasic = new ArrayList<>();
			UserRight userRightBasic = new UserRight(RIGHT_COMMENT);
			userRightsBasic.add(userRightBasic);
			userRightBasic = new UserRight(RIGHT_MESSAGE);
			userRightsBasic.add(userRightBasic); /* Saving user rights in DataBase */
			userRightServ.saveAll(userRightsBasic); /* Saving role basic for regular users in DataBase */
			UserRole userRoleBasic = new UserRole(BASIC, userRightsBasic);
			userRoleServ.save(userRoleBasic);
		}
		try {
			userRoleServ.findByName(ADMIN);
		} catch (NotFoundException e) {
			List<UserRight> userRightsAdmin = new ArrayList<UserRight>();
			UserRight userRightAdmin = new UserRight(RIGHT_ADMINISTRATION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(RIGHT_ACCOUNT_SUPPRESION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(RIGHT_PLANT_SUPPRESSION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(RIGHT_PLANT_ADDITION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(RIGHT_PLANT_MODIFICATION);
			userRightsAdmin.add(userRightAdmin); /* Saving admin rights in DataBase */
			userRightServ.saveAll(userRightsAdmin); /* Saving role admin for regular users in DataBase */
			userRightsAdmin.addAll(userRoleServ.findByName(BASIC).getUserRights());
			UserRole userRoleAdmin = new UserRole(ADMIN, userRightsAdmin);
			userRoleServ.save(userRoleAdmin);
		}
		try {
			userAccServ.findByNickname("admin");
		} catch (NotFoundException e) {
			/* Saving a admin user in DataBase */
			UserAccount userAccAdmin = new UserAccount("admin", "admin", "admin", userRoleServ.findByName(ADMIN));
			userAccAdmin.setPassword("admin");
			userAccServ.save(userAccAdmin);
		}
		try {
			userAccServ.findByNickname("testNickname");
		} catch (NotFoundException e) {
			/* Saving a basic user in DataBase */
			UserAccount userAccBasic = new UserAccount("testFirstName", "testLastName", "testNickname",
					userRoleServ.findByName(BASIC));
			userAccBasic.setPassword("testPassword");
			userAccServ.save(userAccBasic);
		}
		return userAccServ.findAll();
	}
}