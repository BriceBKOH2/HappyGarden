package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.service.UserRightService;
import diginamic.happygarden.service.UserRoleService;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private UserRightService userRightServ;
	
	@Autowired
	private UserRoleService userRoleServ;
	
	/**
	 * Returns a list of all clients after creating a client for testing
	 * @return
	 */
	@RequestMapping(value ="/initiateDB", method=RequestMethod.GET)
	public List<UserRole> intiateDB() {
		UserRight userRight = new UserRight("basic");
		userRightServ.save(userRight);
		UserRole userRole = new UserRole("admin",userRight);
		userRoleServ.save(userRole);
		return userRoleServ.findAll();
	}
}
