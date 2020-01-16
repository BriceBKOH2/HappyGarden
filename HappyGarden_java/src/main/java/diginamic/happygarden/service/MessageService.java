package diginamic.happygarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
	
	public Optional<Message> findOne(Example<Message> example) {
		return messageRep.findOne(example);
	}
	
	public Optional<Message> findById(Long id) {
		return messageRep.findById(id);
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

	public Message save(Message entitie) {
		return messageRep.save(entitie);
	}

	public List<Message> saveAll(Iterable<Message> entities) {
		return messageRep.saveAll(entities);
	}
	
	public Message saveAndFlush(Message entitie) {
		return messageRep.saveAndFlush(entitie);
	}

	public void flush() {
		messageRep.flush();
	}
	
	public void deleteById(Long id) {
		messageRep.deleteById(id);
		
	}
	public void delete(Message entitie) {
		messageRep.delete(entitie);
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
