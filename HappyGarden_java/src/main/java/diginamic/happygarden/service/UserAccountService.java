package diginamic.happygarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.repository.UserAccountRepository;

@Service
public class UserAccountService{
	
	@Autowired
	UserAccountRepository userAccRep;

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
	
	public Optional<UserAccount> findOne(Example<UserAccount> example) {
		return userAccRep.findOne(example);
	}
	
	public Optional<UserAccount> findById(Long id) {
		return userAccRep.findById(id);
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

	public UserAccount save(UserAccount entitie) {
		return userAccRep.save(entitie);
	}

	public List<UserAccount> saveAll(Iterable<UserAccount> entities) {
		return userAccRep.saveAll(entities);
	}
	
	public UserAccount saveAndFlush(UserAccount entitie) {
		return userAccRep.saveAndFlush(entitie);
	}

	public void flush() {
		userAccRep.flush();
	}
	
	public void deleteById(Long id) {
		userAccRep.deleteById(id);
		
	}
	public void delete(UserAccount entitie) {
		userAccRep.delete(entitie);
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
