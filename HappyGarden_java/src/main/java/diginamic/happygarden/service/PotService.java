package diginamic.happygarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Pot;
import diginamic.happygarden.repository.PotRepository;

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
	
	public Optional<Pot> findOne(Example<Pot> example) {
		return potRep.findOne(example);
	}
	
	public Optional<Pot> findById(Long id) {
		return potRep.findById(id);
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

	public Pot save(Pot entitie) {
		return potRep.save(entitie);
	}

	public List<Pot> saveAll(Iterable<Pot> entities) {
		return potRep.saveAll(entities);
	}
	
	public Pot saveAndFlush(Pot entitie) {
		return potRep.saveAndFlush(entitie);
	}

	public void flush() {
		potRep.flush();
	}
	
	public void deleteById(Long id) {
		potRep.deleteById(id);
		
	}
	public void delete(Pot entitie) {
		potRep.delete(entitie);
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
