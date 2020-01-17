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
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.repository.GardenRepository;

@Service
public class GardenService{
	
	@Autowired
	GardenRepository gardenRep;

	public long count() {
		return gardenRep.count();
	}

	public long count(Example<Garden> example) {
		return gardenRep.count(example);
	}

	public boolean exists(Example<Garden> example) {
		return gardenRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return gardenRep.existsById(id);
	}

	public Garden getOne(Long id) {
		return gardenRep.getOne(id);
	}
	
	public Garden findOne(Example<Garden> example) throws NotFoundException {
		return gardenRep.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public Garden findById(Long id) throws NotFoundException {
		return gardenRep.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public List<Garden> findAll() {
		return gardenRep.findAll();
	}
	
	public List<Garden> findAll(Example<Garden> example) {
		return gardenRep.findAll(example);
	}
	
	public Page<Garden> findAll(Pageable pageable) {
		return gardenRep.findAll(pageable);
	}
	
	public List<Garden> findAll(Sort sort) {
		return gardenRep.findAll(sort);
	}
	
	public List<Garden> findAll(Example<Garden> example, Sort sort) {
		return gardenRep.findAll(example, sort);
	}

	public Page<Garden> findAll(Example<Garden> example, Pageable pageable) {
		return gardenRep.findAll(example, pageable);
	}
	
	public List<Garden> findAllById(Iterable<Long> ids) {
		return gardenRep.findAllById(ids);
	}

	public Garden save(Garden entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			return gardenRep.save(entity);
		}

		try {
			this.findById(entity.getId());
		}
		catch (NotFoundException e) {
			return gardenRep.save(entity);
		}
		throw new AlreadyExistException(entity.getId());
	}

	public List<Garden> saveAll(Iterable<Garden> entities) {
		return gardenRep.saveAll(entities);
	}
	
	public Garden saveAndFlush(Garden entity) {
		return gardenRep.saveAndFlush(entity);
	}
	
	public Garden update(Garden entity) throws NotFoundException {
		this.findById(entity.getId());
		return gardenRep.save(entity);
	}

	public void flush() {
		gardenRep.flush();
	}
	
	public void deleteById(Long id) {
		gardenRep.deleteById(id);
		
	}
	public void delete(Garden entity) {
		gardenRep.delete(entity);
	}

	public void deleteAll(List<Garden> entities) {
		gardenRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		gardenRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Garden> entities) {
		gardenRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		gardenRep.deleteAllInBatch();
	}

}
