package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.repository.PlantRepository;

@Transactional
@Service
public class PlantService extends AbstractService<Plant, Long, PlantRepository> {
	
	public List<Plant> findByCommonNameOrScientificNameIgnoreCaseContains(String name) {
		return repo.findByCommonNameOrScientificNameIgnoreCaseContains(name,name);
	}
}
