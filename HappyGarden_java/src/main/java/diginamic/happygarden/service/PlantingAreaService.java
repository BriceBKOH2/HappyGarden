package diginamic.happygarden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.PlantingArea;
import diginamic.happygarden.repository.PlantingAreaRepository;

@Service
public class PlantingAreaService{
	
	@Autowired
	PlantingAreaRepository plantingAreaRep;

	public long count() {
		return plantingAreaRep.count();
	}

	public long count(Example<PlantingArea> example) {
		return plantingAreaRep.count(example);
	}

	public boolean exists(Example<PlantingArea> example) {
		return plantingAreaRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return plantingAreaRep.existsById(id);
	}

	public PlantingArea getOne(Long id) {
		return plantingAreaRep.getOne(id);
	}
	
	public PlantingArea findOne(Example<PlantingArea> example) throws NotFoundException {
		return plantingAreaRep.findOne(example).orElseThrow(() -> new NotFoundException("PlantingArea not found"));
	}
	
	public PlantingArea findById(Long id) throws NotFoundException {
		return plantingAreaRep.findById(id).orElseThrow(() -> new NotFoundException("PlantingArea not found"));
	}

	public List<PlantingArea> findAll() {
		return plantingAreaRep.findAll();
	}
	
	public List<PlantingArea> findAll(Example<PlantingArea> example) {
		return plantingAreaRep.findAll(example);
	}
	
	public Page<PlantingArea> findAll(Pageable pageable) {
		return plantingAreaRep.findAll(pageable);
	}
	
	public List<PlantingArea> findAll(Sort sort) {
		return plantingAreaRep.findAll(sort);
	}
	
	public List<PlantingArea> findAll(Example<PlantingArea> example, Sort sort) {
		return plantingAreaRep.findAll(example, sort);
	}

	public Page<PlantingArea> findAll(Example<PlantingArea> example, Pageable pageable) {
		return plantingAreaRep.findAll(example, pageable);
	}
	
	public List<PlantingArea> findAllById(Iterable<Long> ids) {
		return plantingAreaRep.findAllById(ids);
	}

	public PlantingArea save(PlantingArea entity) {
		return plantingAreaRep.save(entity);
	}

	public List<PlantingArea> saveAll(Iterable<PlantingArea> entities) {
		return plantingAreaRep.saveAll(entities);
	}
	
	public PlantingArea saveAndFlush(PlantingArea entity) {
		return plantingAreaRep.saveAndFlush(entity);
	}

	public void flush() {
		plantingAreaRep.flush();
	}
	
	public void deleteById(Long id) {
		plantingAreaRep.deleteById(id);
		
	}
	public void delete(PlantingArea entity) {
		plantingAreaRep.delete(entity);
	}

	public void deleteAll(List<PlantingArea> entities) {
		plantingAreaRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		plantingAreaRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<PlantingArea> entities) {
		plantingAreaRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		plantingAreaRep.deleteAllInBatch();
		
	}

}
