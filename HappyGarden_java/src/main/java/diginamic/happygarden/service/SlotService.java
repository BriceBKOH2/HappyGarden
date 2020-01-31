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
import diginamic.happygarden.model.Reminder;
import diginamic.happygarden.model.Slot;
import diginamic.happygarden.repository.SlotRepository;

@Service
public class SlotService {

	@Autowired
	SlotRepository slotRep;
	
	@Autowired
	PlantService plantServ;
	
	@Autowired
	ReminderService remServ;
	
	public long count() {
		return slotRep.count();
	}

	public long count(Example<Slot> example) {
		return slotRep.count(example);
	}

	public boolean exists(Example<Slot> example) {
		return slotRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return slotRep.existsById(id);
	}

	public Slot getOne(Long id) {
		return slotRep.getOne(id);
	}
	
	public Slot findOne(Example<Slot> example) throws NotFoundException {
		return slotRep.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public Slot findById(Long id) throws NotFoundException {
		return slotRep.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public List<Slot> findAll() {
		return slotRep.findAll();
	}
	
	public List<Slot> findAll(Example<Slot> example) {
		return slotRep.findAll(example);
	}
	
	public Page<Slot> findAll(Pageable pageable) {
		return slotRep.findAll(pageable);
	}
	
	public List<Slot> findAll(Sort sort) {
		return slotRep.findAll(sort);
	}
	
	public List<Slot> findAll(Example<Slot> example, Sort sort) {
		return slotRep.findAll(example, sort);
	}

	public Page<Slot> findAll(Example<Slot> example, Pageable pageable) {
		return slotRep.findAll(example, pageable);
	}
	
	public List<Slot> findAllById(Iterable<Long> ids) {
		return slotRep.findAllById(ids);
	}

	public Slot save(Slot entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			plantServ.save(entity.getPlant());
			for (Reminder c : entity.getReminders()) {
				remServ.save(c);
			}
			return slotRep.save(entity);
		}

		try {
			this.findById(entity.getId());
		}
		catch (NotFoundException e) {
			return slotRep.save(entity);
		}
		throw new AlreadyExistException(entity.getId());
	}

	public List<Slot> saveAll(Iterable<Slot> entities) {
		return slotRep.saveAll(entities);
	}
	
	public Slot saveAndFlush(Slot entity) {
		return slotRep.saveAndFlush(entity);
	}
	
	public Slot update(Slot entity) throws NotFoundException {
		this.findById(entity.getId());
		return slotRep.save(entity);
	}

	public void flush() {
		slotRep.flush();
	}
	
	public void deleteById(Long id) {
		slotRep.deleteById(id);
		
	}
	public void delete(Slot entity) {
		slotRep.delete(entity);
	}

	public void deleteAll(List<Slot> entities) {
		slotRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		slotRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Slot> entities) {
		slotRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		slotRep.deleteAllInBatch();
	}

	
}
