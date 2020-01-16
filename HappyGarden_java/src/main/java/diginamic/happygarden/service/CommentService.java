package diginamic.happygarden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Comment;
import diginamic.happygarden.repository.CommentRepository;

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
	
	public Optional<Comment> findOne(Example<Comment> example) {
		return commentRep.findOne(example);
	}
	
	public Optional<Comment> findById(Long id) {
		return commentRep.findById(id);
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

	public Comment save(Comment entitie) {
		return commentRep.save(entitie);
	}

	public List<Comment> saveAll(Iterable<Comment> entities) {
		return commentRep.saveAll(entities);
	}
	
	public Comment saveAndFlush(Comment entitie) {
		return commentRep.saveAndFlush(entitie);
	}

	public void flush() {
		commentRep.flush();
	}
	
	public void deleteById(Long id) {
		commentRep.deleteById(id);
		
	}
	public void delete(Comment entitie) {
		commentRep.delete(entitie);
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
