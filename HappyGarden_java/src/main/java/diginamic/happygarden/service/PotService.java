package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Pot;
import diginamic.happygarden.repository.PotRepository;

@Transactional
@Service
public class PotService{
	
	@Autowired
	PotRepository potRep;

	public long count() {
		return potRep.count();
	}

	public long count(Example<Pot> example) {
		return potRep.count(example);
	}

	public boolean exists(Example<Pot> example) {
		return potRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return potRep.existsById(id);
	}

	public Pot getOne(Long id) {
		return potRep.getOne(id);
	}
	
	public Pot findOne(Example<Pot> example) throws NotFoundException {
		return potRep.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public Pot findById(Long id) throws NotFoundException {
		return potRep.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public List<Pot> findAll() {
		return potRep.findAll();
	}
	
	public List<Pot> findAll(Example<Pot> example) {
		return potRep.findAll(example);
	}
	
	public Page<Pot> findAll(Pageable pageable) {
		return potRep.findAll(pageable);
	}
	
	public List<Pot> findAll(Sort sort) {
		return potRep.findAll(sort);
	}
	
	public List<Pot> findAll(Example<Pot> example, Sort sort) {
		return potRep.findAll(example, sort);
	}

	public Page<Pot> findAll(Example<Pot> example, Pageable pageable) {
		return potRep.findAll(example, pageable);
	}
	
	public List<Pot> findAllById(Iterable<Long> ids) {
		return potRep.findAllById(ids);
	}

	public Pot save(Pot entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			return potRep.save(entity);
		}

		throw new AlreadyExistException(entity.getId());
	}

	public List<Pot> saveAll(Iterable<Pot> entities) {
		return potRep.saveAll(entities);
	}
	
	public Pot saveAndFlush(Pot entity) {
		return potRep.saveAndFlush(entity);
	}
	
	public Pot update(Pot entity) throws NotFoundException {
		this.findById(entity.getId());
		return potRep.save(entity);
	}

	public void flush() {
		potRep.flush();
	}
	
	public void deleteById(Long id) {
		potRep.deleteById(id);
		
	}
	public void delete(Pot entity) {
		potRep.delete(entity);
	}

	public void deleteAll(List<Pot> entities) {
		potRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		potRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Pot> entities) {
		potRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		potRep.deleteAllInBatch();
	}

}
