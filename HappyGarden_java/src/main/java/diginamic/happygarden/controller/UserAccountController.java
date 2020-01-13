package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.repository.UserAccountRepository;
import diginamic.happygarden.repository.UserRightRepository;
import diginamic.happygarden.repository.UserRoleRepository;

@RestController
public class UserAccountController {
	
	@Autowired
	private UserAccountRepository userAccRep;
	
	@Autowired
	private UserRightRepository userRightRep;
	
	@Autowired
	private UserRoleRepository userRoleRep;
	
	@RequestMapping(value ="/UserAccount/", method=RequestMethod.GET)
	public List<UserAccount> createUserAccount() {
		UserRight userRight = new UserRight("basic");
		userRightRep.save(userRight);
		UserRole userRole = new UserRole("Utilisateur", userRight);
		userRoleRep.save(userRole);
		UserAccount userAcc = new UserAccount("Jean", "Jade", "CoucouCestMoi",userRole);
		userAcc.setPseudonyme("coco");
		userAcc.setPassword("password");
		userAccRep.save(userAcc);
		System.out.println("c'est bon");
		return userAccRep.findAll();
	}
	
}
