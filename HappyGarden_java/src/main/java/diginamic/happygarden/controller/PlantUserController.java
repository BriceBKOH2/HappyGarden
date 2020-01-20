package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.PlantUser;
import diginamic.happygarden.service.PlantUserService;

@RestController
@RequestMapping("/PlantUserUser")
public class PlantUserController {

	@Autowired
	private PlantUserService plantUserServ;
	
	/**
	 * Returns a list of all users.
	 * 
	 * @return List<PlantUser>
	 */
	@GetMapping
	public List<PlantUser> findAll() {
		return plantUserServ.findAll();
	}

	/**
	 * Returns a user based on id.
	 * 
	 * @return	PlantUser
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/{id}")
	public PlantUser findById(@PathVariable Long id) throws NotFoundException {
		return plantUserServ.findById(id);
	}
	
	/**
	 * Create a user in Database and return the updated user.
	 * 
	 * @return	PlantUser
	 * @throws AlreadyExistException 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlantUser save(@RequestBody PlantUser plantUser) throws AlreadyExistException {
		return plantUserServ.save(plantUser);
	}
	
	/**
	 * Update a user in Database and return it.
	 * 
	 * @return	PlantUser
	 * @throws NotFoundException 
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public PlantUser update(@RequestBody PlantUser plantUser) throws NotFoundException {
		return plantUserServ.update(plantUser);	
	}
	
	/**
	 * Delete a user in Database.
	 */
	@PreAuthorize("account_suppression")
	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@RequestBody PlantUser plantUser) {
		plantUserServ.delete(plantUser);
	}

}
