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
import diginamic.happygarden.model.Plant;
import diginamic.happygarden.service.PlantService;

@RestController
@RequestMapping("/Plant")
public class PlantController {

	@Autowired
	private PlantService plantServ;
	
	/**
	 * Returns a list of all users.
	 * 
	 * @return List<Plant>
	 */
	@GetMapping
	public List<Plant> findAll() {
		return plantServ.findAll();
	}

	/**
	 * Returns a user based on id.
	 * 
	 * @return	Plant
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/{id}")
	public Plant findById(@PathVariable Long id) throws NotFoundException {
		return plantServ.findById(id);
	}
	
	/**
	 * Create a user in Database and return the updated user.
	 * 
	 * @return	Plant
	 * @throws AlreadyExistException 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Plant save(@RequestBody Plant plant) throws AlreadyExistException {
		return plantServ.save(plant);
	}
	
	/**
	 * Update a user in Database and return it.
	 * 
	 * @return	Plant
	 * @throws NotFoundException 
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Plant update(@RequestBody Plant plant) throws NotFoundException {
		return plantServ.update(plant);
		
	}
	
	/**
	 * Delete a user in Database.
	 */
	@PreAuthorize("account_suppression")
	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@RequestBody Plant plant) {
		plantServ.delete(plant);
	}
	
}
