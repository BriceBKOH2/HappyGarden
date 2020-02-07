package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.repository.UserAccountRepository;

@Transactional
@Service
public class UserAccountService extends AbstractService<UserAccount, Long, UserAccountRepository> {

	@Autowired
	ConversationService convServ;

	@Autowired
	GardenService gardenServ;

	@Autowired
	PlantService plantServ;
	


	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UserAccount> findAllByFirstnameIgnoreCase(String name) {
		return repo.findAllByFirstnameIgnoreCase(name);
	}
	
	public List<UserAccount> findByLastnameIgnoreCase(String name) {
		return repo.findByLastnameIgnoreCase(name);
	}

	public UserAccount findByNickname(String nickname) throws NotFoundException {
		return repo.findByNickname(nickname).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public UserAccount findByIdFetchAll(Long id) {
		return repo.findByIdFetchAll(id).get();
	}

	public UserAccount save(UserAccount entity) throws AlreadyExistException {

		if (entity.getId() == null) {
			entity.setPassword(passwordEncoder.encode(entity.getPassword()));
			return repo.save(entity);
		}
		throw new AlreadyExistException(entity.getId());
	}

	public List<UserAccount> saveAll(Iterable<UserAccount> entities) {
		entities.forEach(entity -> entity.setPassword(passwordEncoder.encode(entity.getPassword())));
		return repo.saveAll(entities);
	}

	public UserAccount saveAndFlush(UserAccount entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return repo.saveAndFlush(entity);
	}
}
