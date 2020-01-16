package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.service.UserAccountService;

@RestController
@RequestMapping("/UserAccount")
public class UserAccountController {
	
	@Autowired
	private UserAccountService userAccServ;
	
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
