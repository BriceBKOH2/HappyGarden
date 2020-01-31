package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Garden;
import diginamic.happygarden.repository.GardenRepository;

@Transactional
@Service
public class GardenService extends AbstractService<Garden, Long, GardenRepository> {
	
}
