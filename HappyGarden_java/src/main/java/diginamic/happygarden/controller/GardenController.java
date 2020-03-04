package diginamic.happygarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.service.GardenService;
import diginamic.happygarden.service.PlantingAreaService;

@RestController
@RequestMapping("/Garden")
public class GardenController extends AbstractCRUDController<Garden, Long, GardenService> {
	
	@Autowired
	private PlantingAreaService plantingAreaServ;

	@GetMapping(value = "/{id}/count")
	public long countPlantingAreas(@PathVariable Long id) throws NotFoundException {
		return plantingAreaServ.countPlantingAreas(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		service.deleteById(id);
		
	}
	
}
