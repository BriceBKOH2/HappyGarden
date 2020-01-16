package diginamic.happygarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.PlantUser;
import diginamic.happygarden.repository.PlantUserRepository;

@Service
public class PlantUserService{

	@Autowired
	PlantUserRepository plantUserRep;
	
	public long count() {
		return plantUserRep.count();
	}

	public long count(Example<PlantUser> example) {
		return plantUserRep.count(example);
	}

	public boolean exists(Example<PlantUser> example) {
		return plantUserRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return plantUserRep.existsById(id);
	}

	public PlantUser getOne(Long id) {
		return plantUserRep.getOne(id);
	}
	
	public Optional<PlantUser> findOne(Example<PlantUser> example) {
		return plantUserRep.findOne(example);
	}
	
	public Optional<PlantUser> findById(Long id) {
		return plantUserRep.findById(id);
	}

	public List<PlantUser> findAll() {
		return plantUserRep.findAll();
	}
	
	public List<PlantUser> findAll(Example<PlantUser> example) {
		return plantUserRep.findAll(example);
	}
	
	public Page<PlantUser> findAll(Pageable pageable) {
		return plantUserRep.findAll(pageable);
	}
	
	public List<PlantUser> findAll(Sort sort) {
		return plantUserRep.findAll(sort);
	}
	
	public List<PlantUser> findAll(Example<PlantUser> example, Sort sort) {
		return plantUserRep.findAll(example, sort);
	}

	public Page<PlantUser> findAll(Example<PlantUser> example, Pageable pageable) {
		return plantUserRep.findAll(example, pageable);
	}
	
	public List<PlantUser> findAllById(Iterable<Long> ids) {
		return plantUserRep.findAllById(ids);
	}

	public PlantUser save(PlantUser entitie) {
		return plantUserRep.save(entitie);
	}

	public List<PlantUser> saveAll(Iterable<PlantUser> entities) {
		return plantUserRep.saveAll(entities);
	}
	
	public PlantUser saveAndFlush(PlantUser entitie) {
		return plantUserRep.saveAndFlush(entitie);
	}

	public void flush() {
		plantUserRep.flush();
	}
	
	public void deleteById(Long id) {
		plantUserRep.deleteById(id);
		
	}
	public void delete(PlantUser entitie) {
		plantUserRep.delete(entitie);
	}

	public void deleteAll(List<PlantUser> entities) {
		plantUserRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		plantUserRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<PlantUser> entities) {
		plantUserRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		plantUserRep.deleteAllInBatch();
		
	}
}
