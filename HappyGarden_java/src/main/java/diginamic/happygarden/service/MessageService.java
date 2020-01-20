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
import diginamic.happygarden.model.Message;
import diginamic.happygarden.repository.MessageRepository;

@Service
public class MessageService{
	
	@Autowired
	MessageRepository messageRep;

	public long count() {
		return messageRep.count();
	}

	public long count(Example<Message> example) {
		return messageRep.count(example);
	}

	public boolean exists(Example<Message> example) {
		return messageRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return messageRep.existsById(id);
	}

	public Message getOne(Long id) {
		return messageRep.getOne(id);
	}
	
	public Message findOne(Example<Message> example) throws NotFoundException {
		return messageRep.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public Message findById(Long id) throws NotFoundException {
		return messageRep.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public List<Message> findAll() {
		return messageRep.findAll();
	}
	
	public List<Message> findAll(Example<Message> example) {
		return messageRep.findAll(example);
	}
	
	public Page<Message> findAll(Pageable pageable) {
		return messageRep.findAll(pageable);
	}
	
	public List<Message> findAll(Sort sort) {
		return messageRep.findAll(sort);
	}
	
	public List<Message> findAll(Example<Message> example, Sort sort) {
		return messageRep.findAll(example, sort);
	}

	public Page<Message> findAll(Example<Message> example, Pageable pageable) {
		return messageRep.findAll(example, pageable);
	}
	
	public List<Message> findAllById(Iterable<Long> ids) {
		return messageRep.findAllById(ids);
	}

	public Message save(Message entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			return messageRep.save(entity);
		}

		try {
			this.findById(entity.getId());
		}
		catch (NotFoundException e) {
			return messageRep.save(entity);
		}
		throw new AlreadyExistException(entity.getId());
	}

	public List<Message> saveAll(Iterable<Message> entities) {
		return messageRep.saveAll(entities);
	}
	
	public Message saveAndFlush(Message entity) {
		return messageRep.saveAndFlush(entity);
	}
	
	public Message update(Message entity) throws NotFoundException {
		this.findById(entity.getId());
		return messageRep.save(entity);
	}

	public void flush() {
		messageRep.flush();
	}
	
	public void deleteById(Long id) {
		messageRep.deleteById(id);
		
	}
	public void delete(Message entity) {
		messageRep.delete(entity);
	}

	public void deleteAll(List<Message> entities) {
		messageRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		messageRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Message> entities) {
		messageRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		messageRep.deleteAllInBatch();
	}

}
