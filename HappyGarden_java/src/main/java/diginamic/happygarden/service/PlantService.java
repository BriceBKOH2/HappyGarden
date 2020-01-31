package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.repository.PlantRepository;

@Transactional
@Service
public class PlantService extends AbstractService<Plant, Long, PlantRepository> {

}
