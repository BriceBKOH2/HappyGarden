package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.service.PlantService;

@RestController
@RequestMapping("/Plant")
public class PlantController extends AbstractCRUDController<Plant, Long, PlantService> {

	@GetMapping("/search")
	public List<Plant> searchByName(String name) {
		return service.findByCommonNameOrScientificNameIgnoreCaseContains(name);
	}
}