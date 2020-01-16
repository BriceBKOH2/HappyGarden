package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.service.UserAccountService;
import diginamic.happygarden.service.UserRoleService;

@RestController
@RequestMapping("/UserAccount")
public class UserAccountController {
	
	@Autowired
	private UserAccountService userAccServ;
	
	@Autowired
	private UserRoleService userRoleServ;
	
	/**
	 * Returns a list of all clients after creating a client for testing
	 * @return
	 */
	@RequestMapping(value ="/test", method=RequestMethod.GET)
	public List<UserAccount> testUserAccount() {
		UserAccount userAcc = new UserAccount("test", "test", "CoucouCestMoiLeTest",userRoleServ.findByName("admin").get());
		userAcc.setPseudonyme("coco");
		userAcc.setPassword("password");
		userAccServ.save(userAcc);
		System.out.println("test");
		return userAccServ.findAll();
	}
	
	/**
	 * Returns a list of all clients.
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<UserAccount> findAll() {
		return userAccServ.findAll();
	}
	
	
	
}
