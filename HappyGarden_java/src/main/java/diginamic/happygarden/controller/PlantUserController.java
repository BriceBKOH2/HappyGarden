package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.model.PlantUser;
import diginamic.happygarden.service.PlantUserService;

@RestController
@RequestMapping("/PlantUser")
public class PlantUserController extends AbstractCRUDController<PlantUser, Long, PlantUserService> {
	
	@GetMapping("/user")
	public List<Plant> findByCreator(@RequestParam("name") String name) {
		return service.findByCreator(name);
	}
	
	@GetMapping("/searchPlantUser")
	public List<Plant> findByCommonNameIgnoreCaseContainsOrScientificNameIgnoreCaseContains(@RequestParam String name, @RequestParam String creator) {
		return service.findByCommonNameIgnoreCaseContainsOrScientificNameIgnoreCaseContains(name, creator);
	}
}
