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
import diginamic.happygarden.model.Slot;
import diginamic.happygarden.service.SlotService;

@RestController
@RequestMapping("/Slot")
public class SlotController {

	@Autowired
	private SlotService slotServ;

	/**
	 * Returns a list of all Slot.
	 * 
	 * @return List<Slot>
	 */
	@GetMapping
	public List<Slot> findAll() {
		return slotServ.findAll();
	}

	/**
	 * Returns a Slot based on id.
	 * 
	 * @return Slot
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/{id}")
	public Slot findById(@PathVariable Long id) throws NotFoundException {
		return slotServ.findById(id);
	}

	/**
	 * Create a Slot in Database and return the updated Slot.
	 * 
	 * @return Slot
	 * @throws AlreadyExistException
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Slot save(@RequestBody Slot slot) throws AlreadyExistException {
		return slotServ.save(slot);
//		try {
//			return gardenServ.findById(garden.getId());
//		} catch (NotFoundException e) {
//			return null;
//		}
	}

	/**
	 * Update a Slot in Database and return it.
	 * 
	 * @return Slot
	 * @throws NotFoundException
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Slot update(@RequestBody Slot slot) throws NotFoundException {
		return slotServ.update(slot);
	}

	/**
	 * Delete a Slot in Database.
	 */
	@PreAuthorize("account_suppression")
	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@RequestBody Slot slot) {
		slotServ.delete(slot);
	}

}
