package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.PlantUser;
import diginamic.happygarden.repository.PlantUserRepository;

@Transactional
@Service
public class PlantUserService extends AbstractService<PlantUser, Long, PlantUserRepository> {

}
