package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.model.PlantUser;
import diginamic.happygarden.repository.PlantUserRepository;

@Transactional
@Service
public class PlantUserService extends AbstractService<PlantUser, Long, PlantUserRepository> {
	public List<Plant> findByCommonNameOrScientificName(String name) {
		return repo.findByCommonNameOrScientificName(name,name);
	}
	
	public List<Plant> findByCreator(String name) {
		return repo.findByCreator(name);
	}

	
}
