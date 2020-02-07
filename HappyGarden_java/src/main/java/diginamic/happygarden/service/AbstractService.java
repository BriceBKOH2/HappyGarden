package diginamic.happygarden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.HibernateEntity;

/**
 * Abstract Service class containing all base methods for services.
 * @author formation
 *
 * @param <T> the type of the entity to be manipulated by this class.
 * @param <ID> the type of the id of the entity.
 */
@Service
public abstract class AbstractService<T extends HibernateEntity<ID>, ID, R extends JpaRepository<T, ID>> {
	
	@Autowired
	protected R repo;
	
	public long count() {
		return repo.count();
	}

	public long count(Example<T> example) {
		return repo.count(example);
	}

	public boolean exists(Example<T> example) {
		return repo.exists(example);
	}
	
	public boolean existsById(ID id) {
		return repo.existsById(id);
	}

	public T getOne(ID id) {
		return repo.getOne(id);
	}
	
	public T findOne(Example<T> example) throws NotFoundException {
		return repo.findOne(example).orElseThrow(() -> new NotFoundException("Entity not found"));
	}
	
	public T findById(ID id) throws NotFoundException {
		return repo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public List<T> findAll() {
		return repo.findAll();
	}
	
	public List<T> findAll(Example<T> example) {
		return repo.findAll(example);
	}
	
	public Page<T> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	public List<T> findAll(Sort sort) {
		return repo.findAll(sort);
	}
	
	public List<T> findAll(Example<T> example, Sort sort) {
		return repo.findAll(example, sort);
	}

	public Page<T> findAll(Example<T> example, Pageable pageable) {
		return repo.findAll(example, pageable);
	}
	
	public List<T> findAllById(Iterable<ID> ids) {
		return repo.findAllById(ids);
	}

	public T save(T entity) throws AlreadyExistException {
		if (entity.getId() == null) {
			return repo.save(entity);
		}

		throw new AlreadyExistException(entity.getId());
	}

	public List<T> saveAll(Iterable<T> entities) {
		return repo.saveAll(entities);
	}
	
	public T saveAndFlush(T entity) {
		return repo.saveAndFlush(entity);
	}
	
	public T update(T entity) throws NotFoundException {
		this.findById(entity.getId());
		return repo.save(entity);
	}

	public void flush() {
		repo.flush();
	}
	
	public void deleteById(ID id) {
		repo.deleteById(id);
		
	}
	public void delete(T entity) {
		repo.delete(entity);
	}

	public void deleteAll(List<T> entities) {
		repo.deleteAll(entities);
		
	}

	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void deleteInBatch(Iterable<T> entities) {
		repo.deleteInBatch(entities);
		
	}

	public void deleteAllInBatch() {
		repo.deleteAllInBatch();
	}
	
}
