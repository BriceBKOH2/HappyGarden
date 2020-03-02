package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diginamic.happygarden.model.PlantingArea;
import diginamic.happygarden.repository.PlantingAreaRepository;

@Transactional
@Service
public class PlantingAreaService extends AbstractService<PlantingArea, Long, PlantingAreaRepository> {

	@Autowired
	private PlantingAreaRepository plantingAreaRepository;
	
	public long countPlantingAreas(Long id) {
		
		return plantingAreaRepository.countGardenById(id);
	}

}
