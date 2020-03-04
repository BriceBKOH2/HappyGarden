package diginamic.happygarden.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diginamic.happygarden.classes.PlantApi;
import diginamic.happygarden.exception.AlreadyExistException;
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
	
	public List<Plant> findByScientificNameIgnoreCase(String name) {
		return repo.findByScientificNameIgnoreCase(name);
	}

	public Plant save(PlantApi entity) throws AlreadyExistException {
		Plant plant = new Plant(entity.getScientificName(), entity.getCommonName(), entity.getFamilyCommonName(),
				entity.getToxicity(), entity.getMatureHeight(), entity.getLifeSpan(), entity.getImage(),
				entity.getBloomPeriod(), entity.getGrowthRate(), entity.getSeasons());
		return repo.save(plant);
	}

	public List<Plant> saveAll(List<PlantApi> entities) {
		List<Plant> plants = new ArrayList<>();
		for (PlantApi entity : entities) {
			plants.add(new Plant(entity.getScientificName(), entity.getCommonName(), entity.getFamilyCommonName(),
					entity.getToxicity(), entity.getMatureHeight(), entity.getLifeSpan(), entity.getImage(),
					entity.getBloomPeriod(), entity.getGrowthRate(), entity.getSeasons()));
		}
		return repo.saveAll(plants);
	}
}
