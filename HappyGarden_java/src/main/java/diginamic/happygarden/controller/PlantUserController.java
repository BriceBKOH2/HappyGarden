package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.AlreadyExistException;
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
	// We override the method to avoid @PreAuthorize(UserRight.RIGHT_ADMINISTRATION) from Abstract CRUDController
	@Override
	@PreAuthorize("isAuthenticated()")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public PlantUser save(@RequestBody PlantUser entity) throws AlreadyExistException {
		return service.save(entity);
	}
}
