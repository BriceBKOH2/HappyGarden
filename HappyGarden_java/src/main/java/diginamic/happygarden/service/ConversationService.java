package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Conversation;
import diginamic.happygarden.model.Message;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.repository.ConversationRepository;

@Transactional
@Service
public class ConversationService{
	
	@Autowired
	ConversationRepository conversationRep;
	
	@Autowired
	MessageService messServ;

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
	
	public Conversation findOne(Example<Conversation> example) throws NotFoundException {
		return conversationRep.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public Conversation findById(Long id) throws NotFoundException {
		return conversationRep.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
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

	public Conversation save(Conversation entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			for (Message c : entity.getMessages()) {
				messServ.save(c);
			}
			return conversationRep.save(entity);
		}

		throw new AlreadyExistException(entity.getId());
	}

	public List<Conversation> saveAll(Iterable<Conversation> entities) {
		return conversationRep.saveAll(entities);
	}
	
	public Conversation saveAndFlush(Conversation entity) {
		return conversationRep.saveAndFlush(entity);
	}
	
	public Conversation update(Conversation entity) throws NotFoundException {
		this.findById(entity.getId());
		return conversationRep.save(entity);
	}

	public void flush() {
		conversationRep.flush();
	}
	
	public void deleteById(Long id) {
		conversationRep.deleteById(id);
		
	}
	public void delete(Conversation entity) {
		conversationRep.delete(entity);
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
