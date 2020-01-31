package diginamic.happygarden.service;

import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.repository.UserRoleRepository;

@Service
public class UserRoleService extends AbstractService<UserRole, Long, UserRoleRepository> {

//	@Autowired
//	UserRoleRepository repo;

	public UserRole findByName(String name) throws NotFoundException {
		return repo.findByName(name).orElseThrow(() -> new NotFoundException("User role with name \"" + name + "\" not found.")); 

	}
}
