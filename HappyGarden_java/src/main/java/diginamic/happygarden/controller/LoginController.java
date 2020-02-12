package diginamic.happygarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.service.UserAccountService;

@Controller
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private UserAccountService userAccServ;
	
	@GetMapping
	public UserAccount login(@RequestParam String nickname, @RequestParam String password) {
		if (nickname == null || password == null) {
			return null;
		}
		try {
			if (userAccServ.authentication(nickname, password)) {
				return userAccServ.findByNickname(nickname);
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
