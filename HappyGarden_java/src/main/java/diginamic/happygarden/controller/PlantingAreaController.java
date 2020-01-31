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
import diginamic.happygarden.model.PlantingArea;
import diginamic.happygarden.service.PlantingAreaService;

@RestController
@RequestMapping("/PlantingArea")
public class PlantingAreaController {

	@Autowired
	private PlantingAreaService plantAreaServ;

	/**
	 * Returns a list of all PlantingAreas.
	 * 
	 * @return List<PlantingArea>
	 */
	@GetMapping
	public List<PlantingArea> findAll() {
		return plantAreaServ.findAll();
	}

	/**
	 * Returns a PlantingArea based on id.
	 * 
	 * @return PlantingArea
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/{id}")
	public PlantingArea findById(@PathVariable Long id) throws NotFoundException {
		return plantAreaServ.findById(id);
	}

	/**
	 * Create a PlantingArea in Database and return the updated PlantingArea.
	 * 
	 * @return PlantingArea
	 * @throws AlreadyExistException
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlantingArea save(@RequestBody PlantingArea plantingArea) throws AlreadyExistException {
		return plantAreaServ.save(plantingArea);
//		try {
//			return gardenServ.findById(garden.getId());
//		} catch (NotFoundException e) {
//			return null;
//		}
	}

	/**
	 * Update a PlantingArea in Database and return it.
	 * 
	 * @return PlantingArea
	 * @throws NotFoundException
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public PlantingArea update(@RequestBody PlantingArea plantingArea) throws NotFoundException {
		return plantAreaServ.update(plantingArea);
	}

	/**
	 * Delete a PlantingArea in Database.
	 */
	@PreAuthorize("account_suppression")
	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@RequestBody PlantingArea plantingArea) {
		plantAreaServ.delete(plantingArea);
	}

}
