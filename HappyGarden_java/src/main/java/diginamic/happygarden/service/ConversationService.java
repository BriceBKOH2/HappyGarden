package diginamic.happygarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Conversation;
import diginamic.happygarden.repository.ConversationRepository;

@Service
public class ConversationService{
	
	@Autowired
	ConversationRepository conversationRep;

	public long count() {
		return conversationRep.count();
	}

	public long count(Example<Conversation> example) {
		return conversationRep.count(example);
	}

	public boolean exists(Example<Conversation> example) {
		return conversationRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return conversationRep.existsById(id);
	}

	public Conversation getOne(Long id) {
		return conversationRep.getOne(id);
	}
	
	public Optional<Conversation> findOne(Example<Conversation> example) {
		return conversationRep.findOne(example);
	}
	
	public Optional<Conversation> findById(Long id) {
		return conversationRep.findById(id);
	}

	public List<Conversation> findAll() {
		return conversationRep.findAll();
	}
	
	public List<Conversation> findAll(Example<Conversation> example) {
		return conversationRep.findAll(example);
	}
	
	public Page<Conversation> findAll(Pageable pageable) {
		return conversationRep.findAll(pageable);
	}
	
	public List<Conversation> findAll(Sort sort) {
		return conversationRep.findAll(sort);
	}
	
	public List<Conversation> findAll(Example<Conversation> example, Sort sort) {
		return conversationRep.findAll(example, sort);
	}

	public Page<Conversation> findAll(Example<Conversation> example, Pageable pageable) {
		return conversationRep.findAll(example, pageable);
	}
	
	public List<Conversation> findAllById(Iterable<Long> ids) {
		return conversationRep.findAllById(ids);
	}

	public Conversation save(Conversation entitie) {
		return conversationRep.save(entitie);
	}

	public List<Conversation> saveAll(Iterable<Conversation> entities) {
		return conversationRep.saveAll(entities);
	}
	
	public Conversation saveAndFlush(Conversation entitie) {
		return conversationRep.saveAndFlush(entitie);
	}

	public void flush() {
		conversationRep.flush();
	}
	
	public void deleteById(Long id) {
		conversationRep.deleteById(id);
		
	}
	public void delete(Conversation entitie) {
		conversationRep.delete(entitie);
	}

	public void deleteAll(List<Conversation> entities) {
		conversationRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		conversationRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Conversation> entities) {
		conversationRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		conversationRep.deleteAllInBatch();
		
	}
}
