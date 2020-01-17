package diginamic.happygarden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserRight;
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
	
	public UserRole findOne(Example<UserRole> example) throws NotFoundException {
		return userRoleRep.findOne(example).orElseThrow(() -> new NotFoundException("User not found"));
	}
	
	public UserRole findById(Long id) throws NotFoundException {
		return userRoleRep.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
	}
	
	public UserRole findByName(String name) throws NotFoundException {
		return userRoleRep.findByName(name).orElseThrow(() -> new NotFoundException("Entity not found"));
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

	public UserRole save(UserRole entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			return userRoleRep.save(entity);
		}

		try {
			this.findById(entity.getId());
		}
		catch (NotFoundException e) {
			return userRoleRep.save(entity);
		}
		throw new AlreadyExistException(entity.getId());
	}

	public List<UserRole> saveAll(Iterable<UserRole> entities) {
		return userRoleRep.saveAll(entities);
	}
	
	public UserRole saveAndFlush(UserRole entity) {
		return userRoleRep.saveAndFlush(entity);
	}
	
	public UserRole update(UserRole entity) throws NotFoundException {
		this.findById(entity.getId());
		return userRoleRep.save(entity);
	}

	public void flush() {
		userRoleRep.flush();
	}
	
	public void deleteById(Long id) {
		userRoleRep.deleteById(id);
		
	}
	public void delete(UserRole entity) {
		userRoleRep.delete(entity);
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
