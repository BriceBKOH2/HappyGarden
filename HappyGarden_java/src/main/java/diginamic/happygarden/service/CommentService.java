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
import diginamic.happygarden.model.Comment;
import diginamic.happygarden.repository.CommentRepository;

@Transactional
@Service
public class CommentService{
	
	@Autowired
	CommentRepository commentRep;

	public long count() {
		return commentRep.count();
	}

	public long count(Example<Comment> example) {
		return commentRep.count(example);
	}

	public boolean exists(Example<Comment> example) {
		return commentRep.exists(example);
	}
	
	public boolean existsById(Long id) {
		return commentRep.existsById(id);
	}

	public Comment getOne(Long id) {
		return commentRep.getOne(id);
	}
	
	public Comment findOne(Example<Comment> example) throws NotFoundException {
		return commentRep.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public Comment findById(Long id) throws NotFoundException {
		return commentRep.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	public List<Comment> findAll() {
		return commentRep.findAll();
	}
	
	public List<Comment> findAll(Example<Comment> example) {
		return commentRep.findAll(example);
	}
	
	public Page<Comment> findAll(Pageable pageable) {
		return commentRep.findAll(pageable);
	}
	
	public List<Comment> findAll(Sort sort) {
		return commentRep.findAll(sort);
	}
	
	public List<Comment> findAll(Example<Comment> example, Sort sort) {
		return commentRep.findAll(example, sort);
	}

	public Page<Comment> findAll(Example<Comment> example, Pageable pageable) {
		return commentRep.findAll(example, pageable);
	}
	
	public List<Comment> findAllById(Iterable<Long> ids) {
		return commentRep.findAllById(ids);
	}

	public Comment save(Comment entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			return commentRep.save(entity);
		}

		throw new AlreadyExistException(entity.getId());
	}

	public List<Comment> saveAll(Iterable<Comment> entities) {
		return commentRep.saveAll(entities);
	}
	
	public Comment saveAndFlush(Comment entity) {
		return commentRep.saveAndFlush(entity);
	}
	
	public Comment update(Comment entity) throws NotFoundException {
		this.findById(entity.getId());
		return commentRep.save(entity);
	}

	public void flush() {
		commentRep.flush();
	}
	
	public void deleteById(Long id) {
		commentRep.deleteById(id);
		
	}
	public void delete(Comment entity) {
		commentRep.delete(entity);
	}

	public void deleteAll(List<Comment> entities) {
		commentRep.deleteAll(entities);
		
	}

	public void deleteAll() {
		commentRep.deleteAll();
	}
	
	public void deleteInBatch(Iterable<Comment> entities) {
		commentRep.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		commentRep.deleteAllInBatch();
	}

}
