package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.repository.PlantRepository;
import diginamic.happygarden.repository.PlantingAreaRepository;

@Transactional
@Service
public class PlantService extends AbstractService<Plant, Long, PlantRepository> {
	@Autowired
	private PlantRepository plantRepository;

	public List<Plant> findByCommonNameOrScientificName(String name) {
		return repo.findByCommonNameOrScientificName(name, name);
	}

	public List<Plant> findByCommonNameIgnoreCaseContainsOrScientificNameIgnoreCaseContains(String name) {
		return repo.findByCommonNameIgnoreCaseContainsOrScientificNameIgnoreCaseContains(name, name);
	}


}
