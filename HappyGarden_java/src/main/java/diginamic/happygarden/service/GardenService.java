package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Garden;
import diginamic.happygarden.repository.GardenRepository;

@Transactional
@Service
public class GardenService extends AbstractService<Garden, Long, GardenRepository> {
	public List<Garden> findByUserId(Long id) {
		return repo.findByUserIdOrderByNameAsc(id);
	}
}
