package diginamic.happygarden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.repository.UserAccountRepository;

@Service
public class UserAccountService extends AbstractService<UserAccount, Long, UserAccountRepository> {

//	@Autowired
//	UserAccountRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UserAccount> findAllByFirstNameIgnoreCase(String name) {
		return repo.findAllByFirstNameIgnoreCase(name);
	}
	
	public List<UserAccount> findByLastNameIgnoreCase(String name) {
		return repo.findByLastNameIgnoreCase(name);
	}

	public UserAccount findByPseudonyme(String pseudonyme) throws NotFoundException {
		return repo.findByPseudonyme(pseudonyme).orElseThrow(() -> new NotFoundException("Entity not found"));
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
