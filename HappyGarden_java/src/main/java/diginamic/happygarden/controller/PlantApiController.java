package diginamic.happygarden.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import diginamic.happygarden.classes.PlantApi;
import diginamic.happygarden.classes.PlantApiLink;
import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.model.Plant;
import diginamic.happygarden.service.PlantService;

@RestController
@RequestMapping("/PlantApi")
public class PlantApiController {
	
	RestTemplate restTemplate = new RestTemplate();
	String urlApi = "https://trefle.io/api/plants";
	String tokenApi = "?token=ajZaYWYwa1ZwMWUyT0NVYkVUd3E3Zz09";
	
	@Autowired
	private PlantService plantServ;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping()
	public List<Plant> getPlantApi() throws InterruptedException {
		List<PlantApiLink> plantLinks = Arrays.asList(restTemplate
				  .getForObject(urlApi + tokenApi + "&page_size=1000", PlantApiLink[].class));
		List<PlantApi> plantApis = new ArrayList<>();
		
		for (PlantApiLink plantApiLink : plantLinks) {
			// Check if the plant will have complete data
			if (plantApiLink.getCompleteData()) {
				// Check if the plant exist in DB
				if(plantServ.findByScientificNameIgnoreCase(plantApiLink.getScientificName()).isEmpty()) {
					plantApis.add(restTemplate.getForObject(urlApi + "/" + plantApiLink.getId() + tokenApi, PlantApi.class));
				}
			}
		}
		
		if (plantApis.isEmpty()) {
			List<Plant> plants = new ArrayList<>();
			return plants;
		}
		
		return plantServ.saveAll(plantApis);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public Plant getPlantApiById(@PathVariable Long id) throws AlreadyExistException {
		PlantApi plantApi = new PlantApi();
		plantApi = restTemplate.getForObject(urlApi + "/" + id + tokenApi, PlantApi.class);
		return plantServ.save(plantApi);
	}
	
}
