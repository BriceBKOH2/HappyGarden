package diginamic.happygarden.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.PlantUser;
import diginamic.happygarden.service.PlantUserService;

@RestController
@RequestMapping("/PlantUser")
public class PlantUserController extends AbstractCRUDController<PlantUser, Long, PlantUserService> {
	
}
