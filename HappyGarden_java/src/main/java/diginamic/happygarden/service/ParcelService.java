package diginamic.happygarden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Parcel;
import diginamic.happygarden.repository.ParcelRepository;

@Service
public class ParcelService{
	
	@Autowired
	ParcelRepository parcelRep;

	public long count() {
		return parcelRep.count();
	}

	public long count(Example<Parcel> example) {
		return parcelRep.count(example);
	}

	public boolean exists(Example<Parcel> example) {
		return parcelRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return parcelRep.existsById(id);
	}

	public Parcel getOne(Long id) {
		return parcelRep.getOne(id);
	}
	
	public Parcel findOne(Example<Parcel> example) throws NotFoundException {
		return parcelRep.findOne(example).orElseThrow(() -> new NotFoundException("Parcel not found"));
	}
	
	public Parcel findById(Long id) throws NotFoundException {
		return parcelRep.findById(id).orElseThrow(() -> new NotFoundException("Parcel not found"));
	}

	public List<Parcel> findAll() {
		return parcelRep.findAll();
	}
	
	public List<Parcel> findAll(Example<Parcel> example) {
		return parcelRep.findAll(example);
	}
	
	public Page<Parcel> findAll(Pageable pageable) {
		return parcelRep.findAll(pageable);
	}
	
	public List<Parcel> findAll(Sort sort) {
		return parcelRep.findAll(sort);
	}
	
	public List<Parcel> findAll(Example<Parcel> example, Sort sort) {
		return parcelRep.findAll(example, sort);
	}

	public Page<Parcel> findAll(Example<Parcel> example, Pageable pageable) {
		return parcelRep.findAll(example, pageable);
	}
	
	public List<Parcel> findAllById(Iterable<Long> ids) {
		return parcelRep.findAllById(ids);
	}

	public Parcel save(Parcel entity) {
		return parcelRep.save(entity);
	}

	public List<Parcel> saveAll(Iterable<Parcel> entities) {
		return parcelRep.saveAll(entities);
	}
	
	public Parcel saveAndFlush(Parcel entity) {
		return parcelRep.saveAndFlush(entity);
	}

	public void flush() {
		parcelRep.flush();
	}
	
	public void deleteById(Long id) {
		parcelRep.deleteById(id);
		
	}
	public void delete(Parcel entity) {
		parcelRep.delete(entity);
	}

	public void deleteAll(List<Parcel> entities) {
		parcelRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		parcelRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Parcel> entities) {
		parcelRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		parcelRep.deleteAllInBatch();
		
	}

}
