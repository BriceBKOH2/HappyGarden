package diginamic.happygarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.repository.UserRoleRepository;

@Service
public class UserRoleService{
	
	@Autowired
	UserRoleRepository userRoleRep;

	public long count() {
		return userRoleRep.count();
	}

	public long count(Example<UserRole> example) {
		return userRoleRep.count(example);
	}

	public boolean exists(Example<UserRole> example) {
		return userRoleRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return userRoleRep.existsById(id);
	}

	public UserRole getOne(Long id) {
		return userRoleRep.getOne(id);
	}
	
	public Optional<UserRole> findOne(Example<UserRole> example) {
		return userRoleRep.findOne(example);
	}
	
	public Optional<UserRole> findById(Long id) {
		return userRoleRep.findById(id);
	}
	
	public Optional<UserRole> findByName(String name) {
		return userRoleRep.findByName(name);
	}

	public List<UserRole> findAll() {
		return userRoleRep.findAll();
	}
	
	public List<UserRole> findAll(Example<UserRole> example) {
		return userRoleRep.findAll(example);
	}
	
	public Page<UserRole> findAll(Pageable pageable) {
		return userRoleRep.findAll(pageable);
	}
	
	public List<UserRole> findAll(Sort sort) {
		return userRoleRep.findAll(sort);
	}
	
	public List<UserRole> findAll(Example<UserRole> example, Sort sort) {
		return userRoleRep.findAll(example, sort);
	}

	public Page<UserRole> findAll(Example<UserRole> example, Pageable pageable) {
		return userRoleRep.findAll(example, pageable);
	}
	
	public List<UserRole> findAllById(Iterable<Long> ids) {
		return userRoleRep.findAllById(ids);
	}

	public UserRole save(UserRole entitie) {
		return userRoleRep.save(entitie);
	}

	public List<UserRole> saveAll(Iterable<UserRole> entities) {
		return userRoleRep.saveAll(entities);
	}
	
	public UserRole saveAndFlush(UserRole entitie) {
		return userRoleRep.saveAndFlush(entitie);
	}

	public void flush() {
		userRoleRep.flush();
	}
	
	public void deleteById(Long id) {
		userRoleRep.deleteById(id);
		
	}
	public void delete(UserRole entitie) {
		userRoleRep.delete(entitie);
	}

	public void deleteAll(List<UserRole> entities) {
		userRoleRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		userRoleRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<UserRole> entities) {
		userRoleRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		userRoleRep.deleteAllInBatch();
		
	}

}
