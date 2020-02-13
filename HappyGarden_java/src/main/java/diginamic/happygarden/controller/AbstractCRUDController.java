package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.HibernateEntity;
import diginamic.happygarden.service.AbstractService;

//Spring 5.1 :
//Controller parameter annotations get detected on interfaces as well: Allowing for complete mapping contracts in controller interfaces.
/**
* Define general CRUD operation for controllers as well as their default
* mappings.
* 
* @author Jomage
* @param <T> The type of the object to be manipulated.
* @param <I> The type of the Id attribute of T
*
*/
@RequestMapping("/default") // AbstractCRUDController<T extends HibernateEntity<I>, I, S extends AbstractService<T, I>> 
public abstract class AbstractCRUDController<T extends HibernateEntity<I>, I, S extends AbstractService<T, I, ? extends JpaRepository<T, I>>> {
	
	// TODO : Add logger and catch + handle errors in methods
//	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCRUDController.class);
	
	@Autowired
	protected S service;
	
	/**
	 * Returns a list of all entities T.
	 * @return List<T>
	 */
	@GetMapping
	public List<T> getAll() {
		return service.findAll();
	}

	/**
	 * Returns the entity with the id in the path variable.
	 * @throws NotFoundException when the entity with the id specified is not found.
	 * @return 
	 */
	@GetMapping("/{id}")
	public T getById(@PathVariable I id) throws NotFoundException {
		return service.findById(id); 
	}

	/**
	 * Saves entity t provided in the request's body.
	 * @param t
	 * @throws AlreadyExistException if the entity already exists.
	 */
	@PostMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseStatus(HttpStatus.CREATED)
	public T save(@RequestBody T t) throws AlreadyExistException {
		return service.save(t);
	}
	
	/**
	 * Updates the entity in Database and returns it.
	 * 
	 * @return the updated entity.
	 * @throws NotFoundException If the entity is not found in the database.
	 */
	@PutMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public T update(@RequestBody T t) throws NotFoundException {
		return service.update(t);
	}
	
	
	/**
	 * Deletes the given entity.
	 * @param t
	 */
	@PreAuthorize(AdminController.RIGHT_ADMINISTRATION)
	@DeleteMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@RequestBody T t) {
		service.delete(t);
	}
	
	/**
	 * Deletes all entities of the type t.
	 */
	@PreAuthorize(AdminController.RIGHT_ADMINISTRATION)
	@DeleteMapping(value = "/deleteall", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public void deleteAll() {
		service.deleteAll();
	}
	
}
