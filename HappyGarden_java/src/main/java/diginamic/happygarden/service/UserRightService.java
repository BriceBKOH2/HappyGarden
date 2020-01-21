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
import diginamic.happygarden.repository.UserRightRepository;

@Service
public class UserRightService{
	
	@Autowired
	UserRightRepository userRightRep;

	public long count() {
		return userRightRep.count();
	}

	public long count(Example<UserRight> example) {
		return userRightRep.count(example);
	}

	public boolean exists(Example<UserRight> example) {
		return userRightRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return userRightRep.existsById(id);
	}

	public UserRight getOne(Long id) {
		return userRightRep.getOne(id);
	}
	
	public UserRight findOne(Example<UserRight> example) throws NotFoundException {
		return userRightRep.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public UserRight findById(Long id) throws NotFoundException {
		return userRightRep.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public UserRight findByName(String name) throws NotFoundException {
		return userRightRep.findByName(name).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public List<UserRight> findAll() {
		return userRightRep.findAll();
	}
	
	public List<UserRight> findAll(Example<UserRight> example) {
		return userRightRep.findAll(example);
	}
	
	public Page<UserRight> findAll(Pageable pageable) {
		return userRightRep.findAll(pageable);
	}
	
	public List<UserRight> findAll(Sort sort) {
		return userRightRep.findAll(sort);
	}
	
	public List<UserRight> findAll(Example<UserRight> example, Sort sort) {
		return userRightRep.findAll(example, sort);
	}

	public Page<UserRight> findAll(Example<UserRight> example, Pageable pageable) {
		return userRightRep.findAll(example, pageable);
	}
	
	public List<UserRight> findAllById(Iterable<Long> ids) {
		return userRightRep.findAllById(ids);
	}

	public UserRight save(UserRight entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			return userRightRep.save(entity);
		}

		throw new AlreadyExistException(entity.getId());
	}

	public List<UserRight> saveAll(Iterable<UserRight> entities) {
		return userRightRep.saveAll(entities);
	}
	
	public UserRight saveAndFlush(UserRight entity) {
		return userRightRep.saveAndFlush(entity);
	}
	
	public UserRight update(UserRight entity) throws NotFoundException {
		this.findById(entity.getId());
		return userRightRep.save(entity);
	}

	public void flush() {
		userRightRep.flush();
	}
	
	public void deleteById(Long id) {
		userRightRep.deleteById(id);
		
	}
	public void delete(UserRight entity) {
		userRightRep.delete(entity);
	}

	public void deleteAll(List<UserRight> entities) {
		userRightRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		userRightRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<UserRight> entities) {
		userRightRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		userRightRep.deleteAllInBatch();
	}

}
