package diginamic.happygarden.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.Garden;
import diginamic.happygarden.service.GardenService;

@RestController
@RequestMapping("/Garden")
public class GardenController extends AbstractCRUDController<Garden, Long, GardenService> {

}
