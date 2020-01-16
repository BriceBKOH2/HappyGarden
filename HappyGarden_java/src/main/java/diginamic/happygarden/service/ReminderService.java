package diginamic.happygarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Reminder;
import diginamic.happygarden.repository.ReminderRepository;

@Service
public class ReminderService{
	
	@Autowired
	ReminderRepository reminderRep;

	public long count() {
		return reminderRep.count();
	}

	public long count(Example<Reminder> example) {
		return reminderRep.count(example);
	}

	public boolean exists(Example<Reminder> example) {
		return reminderRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return reminderRep.existsById(id);
	}

	public Reminder getOne(Long id) {
		return reminderRep.getOne(id);
	}
	
	public Optional<Reminder> findOne(Example<Reminder> example) {
		return reminderRep.findOne(example);
	}
	
	public Optional<Reminder> findById(Long id) {
		return reminderRep.findById(id);
	}

	public List<Reminder> findAll() {
		return reminderRep.findAll();
	}
	
	public List<Reminder> findAll(Example<Reminder> example) {
		return reminderRep.findAll(example);
	}
	
	public Page<Reminder> findAll(Pageable pageable) {
		return reminderRep.findAll(pageable);
	}
	
	public List<Reminder> findAll(Sort sort) {
		return reminderRep.findAll(sort);
	}
	
	public List<Reminder> findAll(Example<Reminder> example, Sort sort) {
		return reminderRep.findAll(example, sort);
	}

	public Page<Reminder> findAll(Example<Reminder> example, Pageable pageable) {
		return reminderRep.findAll(example, pageable);
	}
	
	public List<Reminder> findAllById(Iterable<Long> ids) {
		return reminderRep.findAllById(ids);
	}

	public Reminder save(Reminder entitie) {
		return reminderRep.save(entitie);
	}

	public List<Reminder> saveAll(Iterable<Reminder> entities) {
		return reminderRep.saveAll(entities);
	}
	
	public Reminder saveAndFlush(Reminder entitie) {
		return reminderRep.saveAndFlush(entitie);
	}

	public void flush() {
		reminderRep.flush();
	}
	
	public void deleteById(Long id) {
		reminderRep.deleteById(id);
		
	}
	public void delete(Reminder entitie) {
		reminderRep.delete(entitie);
	}

	public void deleteAll(List<Reminder> entities) {
		reminderRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		reminderRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Reminder> entities) {
		reminderRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		reminderRep.deleteAllInBatch();
		
	}

}
