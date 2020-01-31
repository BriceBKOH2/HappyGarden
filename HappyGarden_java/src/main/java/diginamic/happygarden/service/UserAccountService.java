package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Conversation;
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.model.Plant;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.repository.UserAccountRepository;

@Transactional
@Service
public class UserAccountService {

	@Autowired
	UserAccountRepository userAccRep;

	@Autowired
	ConversationService convServ;

	@Autowired
	GardenService gardenServ;

	@Autowired
	PlantService plantServ;
	


	@Autowired
	private PasswordEncoder passwordEncoder;

	public long count() {
		return userAccRep.count();
	}

	public long count(Example<UserAccount> example) {
		return userAccRep.count(example);
	}

	public boolean exists(Example<UserAccount> example) {
		return userAccRep.exists(example);
	}

	public boolean existsById(Long id) {
		return userAccRep.existsById(id);
	}

	public UserAccount getOne(Long id) {
		return userAccRep.getOne(id);
	}

	public UserAccount findOne(Example<UserAccount> example) throws NotFoundException {
		return userAccRep.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public UserAccount findById(Long id) throws NotFoundException {
		return userAccRep.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public UserAccount findByPseudonyme(String pseudonyme) throws NotFoundException {
		return userAccRep.findByPseudonyme(pseudonyme).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public List<UserAccount> findAll() {
		return userAccRep.findAll();
	}

	public List<UserAccount> findAll(Example<UserAccount> example) {
		return userAccRep.findAll(example);
	}

	public Page<UserAccount> findAll(Pageable pageable) {
		return userAccRep.findAll(pageable);
	}

	public List<UserAccount> findAll(Sort sort) {
		return userAccRep.findAll(sort);
	}

	public List<UserAccount> findAll(Example<UserAccount> example, Sort sort) {
		return userAccRep.findAll(example, sort);
	}

	public Page<UserAccount> findAll(Example<UserAccount> example, Pageable pageable) {
		return userAccRep.findAll(example, pageable);
	}

	public List<UserAccount> findAllById(Iterable<Long> ids) {
		return userAccRep.findAllById(ids);
	}

	public UserAccount save(UserAccount entity) throws AlreadyExistException {

		if (entity.getId() == null) {
			entity.setPassword(passwordEncoder.encode(entity.getPassword()));
			return userAccRep.save(entity);
		}
		throw new AlreadyExistException(entity.getId());
	}

	public List<UserAccount> saveAll(Iterable<UserAccount> entities) throws AlreadyExistException{
		for (UserAccount entity : entities) {
			this.save(entity);
		}
		return (List<UserAccount>) entities;
	}

	public UserAccount saveAndFlush(UserAccount entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return userAccRep.saveAndFlush(entity);
	}

	public UserAccount update(UserAccount entity) throws NotFoundException {
		this.findById(entity.getId());
		return userAccRep.save(entity);
	}

	public void flush() {
		userAccRep.flush();
	}

	public void deleteById(Long id) {
		userAccRep.deleteById(id);

	}

	public void delete(UserAccount entity) {
		userAccRep.delete(entity);
	}

	public void deleteAll(List<UserAccount> entities) {
		userAccRep.deleteAll(entities);

	}

	public void deleteAll() {
		userAccRep.deleteAll();
	}

	public void deleteInBatch(Iterable<UserAccount> entities) {
		userAccRep.deleteInBatch(entities);

	}

	public void deleteAllInBatch() {
		userAccRep.deleteAllInBatch();

	}

}
