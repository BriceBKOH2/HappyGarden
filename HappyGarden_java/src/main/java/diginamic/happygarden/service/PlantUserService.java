package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.model.PlantUser;
import diginamic.happygarden.repository.PlantUserRepository;

@Transactional
@Service
public class PlantUserService extends AbstractService<PlantUser, Long, PlantUserRepository> {
	public List<Plant> findByCommonNameIgnoreCaseContainsOrScientificNameIgnoreCaseContains(String name, String creator) {
		return repo.findByCommonNameIgnoreCaseContainsOrScientificNameIgnoreCaseContains(name, name, creator);
	}
	
	public List<Plant> findByCreator(String name) {
		return repo.findByCreator(name);
	}

	
}
