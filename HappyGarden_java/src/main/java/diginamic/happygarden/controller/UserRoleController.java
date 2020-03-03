package diginamic.happygarden.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.service.UserRoleService;

@RestController
@RequestMapping("/UserRole")
public class UserRoleController extends AbstractCRUDController<UserRole, Long, UserRoleService> {
	
//	getDefaultRole
	@GetMapping("/getDefaultRole")
	public UserRole getDefaultRole() throws NotFoundException {
		return this.service.getDefaultRole();
	}
}