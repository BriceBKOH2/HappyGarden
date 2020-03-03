package diginamic.happygarden.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

/** Controller to retrieve plants for the external API trefle.io 
 *  and convert them to Plant type object with only the data we want.
 *  If you want to see what data are extracted and how see PlantApi and
 *  PlantApiLink.
 *  /!\ /plants gives a different JSON object than /plants/{id} in the external api,
 *  /plants is parsed by PlantApiLink and /plants/{id} by PlantApi
 * @author BriceB
 *
 */
@RestController
@RequestMapping("/PlantApi")
public class PlantApiController {
	
	RestTemplate restTemplate = new RestTemplate();
	// URL needs to be in https to retrieve JSON, http send txt/html content-type
	String urlApi = "https://trefle.io/api/plants";
	String tokenApi = "?token=ajZaYWYwa1ZwMWUyT0NVYkVUd3E3Zz09";
	
	@Autowired
	private PlantService plantServ;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping()
	public List<Plant> getPlantApi() throws InterruptedException {
		List<PlantApiLink> plantLinks = Arrays.asList(restTemplate
				  .getForObject(urlApi + tokenApi + "&page_size=100", PlantApiLink[].class));
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
	@GetMapping(value = {"/Page/{page}","/Page/{page}/PageSize/{page_size}"})
	public List<Plant> getPlantApiPage(@PathVariable Integer page, @PathVariable Optional<Integer> page_size) throws InterruptedException {
		Integer pageSize;
		if (page_size != null && page_size.isPresent()) {
			pageSize = page_size.get();
		} else {
			pageSize = 50;
		}
		System.out.println(urlApi + tokenApi + "&page_size=" + pageSize.toString() +"&page=" + page.toString());
		List<PlantApiLink> plantLinks = Arrays.asList(restTemplate
				  .getForObject(urlApi + tokenApi + "&page_size=" + pageSize.toString() +"&page=" + page.toString(), PlantApiLink[].class));
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
	@GetMapping("/id/{id}")
	public Plant getPlantApiById(@PathVariable Long id) throws AlreadyExistException {
		PlantApi plantApi = new PlantApi();
		plantApi = restTemplate.getForObject(urlApi + "/" + id + tokenApi, PlantApi.class);
		return plantServ.save(plantApi);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/InitDBSimple")
	public void initDBSimple() throws AlreadyExistException, InterruptedException {
		int maxpage = 50;
		for (Integer i = 0; i < maxpage; i++) {
			this.getPlantApiPage(i, null);
		}
		System.out.println("Initialization of" + maxpage + " pages of plants for Trefle.io complete");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/InitDBAllPlant")
	public void initDBAllPlant() throws AlreadyExistException, InterruptedException {
		List<PlantApiLink> plantLinks = new ArrayList<>();
		List<PlantApi> plantApis = new ArrayList<>();
		Integer page = 0;
		do {
			plantLinks = Arrays.asList(restTemplate
					  .getForObject(urlApi + tokenApi + "&page_size=100&page=" + page.toString(), PlantApiLink[].class));
			plantApis = new ArrayList<>();
			page++; // /!\ infinite loop if not incremented
			for (PlantApiLink plantApiLink : plantLinks) {
				// Check if the plant will have complete data
				if (plantApiLink.getCompleteData()) {
					// Check if the plant exist in DB
					if(plantServ.findByScientificNameIgnoreCase(plantApiLink.getScientificName()).isEmpty()) {
						plantApis.add(restTemplate.getForObject(urlApi + "/" + plantApiLink.getId() + tokenApi, PlantApi.class));
					}
				}
			}
			
			if (!plantApis.isEmpty()) {
				plantServ.saveAll(plantApis);
			}
		} while(!plantLinks.isEmpty());
		System.out.println("Initialization of all plants for Trefle.io complete, pages : " + page );
	}
	
	
	
}
