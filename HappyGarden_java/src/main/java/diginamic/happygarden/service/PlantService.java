package diginamic.happygarden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Plant;
import diginamic.happygarden.repository.PlantRepository;

@Service
public class PlantService{
	
	@Autowired
	PlantRepository plantRep;

	public long count() {
		return plantRep.count();
	}

	public long count(Example<Plant> example) {
		return plantRep.count(example);
	}

	public boolean exists(Example<Plant> example) {
		return plantRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return plantRep.existsById(id);
	}

	public Plant getOne(Long id) {
		return plantRep.getOne(id);
	}
	
	public Plant findOne(Example<Plant> example) throws NotFoundException {
		return plantRep.findOne(example).orElseThrow(() -> new NotFoundException("Plant not found"));
	}
	
	public Plant findById(Long id) throws NotFoundException {
		return plantRep.findById(id).orElseThrow(() -> new NotFoundException("Plant not found"));
	}

	public List<Plant> findAll() {
		return plantRep.findAll();
	}
	
	public List<Plant> findAll(Example<Plant> example) {
		return plantRep.findAll(example);
	}
	
	public Page<Plant> findAll(Pageable pageable) {
		return plantRep.findAll(pageable);
	}
	
	public List<Plant> findAll(Sort sort) {
		return plantRep.findAll(sort);
	}
	
	public List<Plant> findAll(Example<Plant> example, Sort sort) {
		return plantRep.findAll(example, sort);
	}

	public Page<Plant> findAll(Example<Plant> example, Pageable pageable) {
		return plantRep.findAll(example, pageable);
	}
	
	public List<Plant> findAllById(Iterable<Long> ids) {
		return plantRep.findAllById(ids);
	}

	public Plant save(Plant entity) {
		return plantRep.save(entity);
	}

	public List<Plant> saveAll(Iterable<Plant> entities) {
		return plantRep.saveAll(entities);
	}
	
	public Plant saveAndFlush(Plant entity) {
		return plantRep.saveAndFlush(entity);
	}

	public void flush() {
		plantRep.flush();
	}
	
	public void deleteById(Long id) {
		plantRep.deleteById(id);
		
	}
	public void delete(Plant entity) {
		plantRep.delete(entity);
	}

	public void deleteAll(List<Plant> entities) {
		plantRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		plantRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Plant> entities) {
		plantRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		plantRep.deleteAllInBatch();
		
	}

}
