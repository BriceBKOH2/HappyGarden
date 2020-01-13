package diginamic.happygarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.repository.UserAccountRepository;

@RestController
public class UserAccountController {
	
	@Autowired
	private UserAccountRepository userAccRepository;
	
	@RequestMapping(value ="/UserAccount/create", method=RequestMethod.GET)
	public void createUserAccount() {
		userAccRepository.save(new UserAccount("Jean", "Jade", "CoucouCestMoi"));
		System.out.println("c'est bon");
	}
	
}
