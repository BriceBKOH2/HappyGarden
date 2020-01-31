package diginamic.happygarden.service;

import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.repository.UserRightRepository;

@Service
public class UserRightService extends AbstractService<UserRight, Long, UserRightRepository> {
	
//	@Autowired
//	UserRightRepository repo;
	
	public UserRight findByName(String name) throws NotFoundException {
		return repo.findByName(name).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
}
