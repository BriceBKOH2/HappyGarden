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
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.service.GardenService;

@RestController
@RequestMapping("/Garden")
public class GardenController {

	@Autowired
	private GardenService gardenServ;
	
	/**
	 * Returns a list of all gardens.
	 * 
	 * @return List<Garden>
	 */
	@GetMapping
	public List<Garden> findAll() {
		return gardenServ.findAll();
	}

	/**
	 * Returns a garden based on id.
	 * 
	 * @return	Garden
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/{id}")
	public Garden findById(@PathVariable Long id) throws NotFoundException {
		return gardenServ.findById(id);
	}
	
	/**
	 * Create a garden in Database and return the updated garden.
	 * 
	 * @return	Garden
	 * @throws AlreadyExistException 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Garden save(@RequestBody Garden garden) throws AlreadyExistException {
		return gardenServ.save(garden);
//		try {
//			return gardenServ.findById(garden.getId());
//		} catch (NotFoundException e) {
//			return null;
//		}
	}
	
	/**
	 * Update a garden in Database and return it.
	 * 
	 * @return	Garden
	 * @throws NotFoundException 
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Garden update(@RequestBody Garden garden) throws NotFoundException {
		return gardenServ.update(garden);
	}
	
	/**
	 * Delete a garden in Database.
	 */
	@PreAuthorize("account_suppression")
	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@RequestBody Garden garden) {
		gardenServ.delete(garden);
	}

}
