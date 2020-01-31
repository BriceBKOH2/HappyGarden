package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Pot;
import diginamic.happygarden.repository.PotRepository;

@Transactional
@Service
public class PotService extends AbstractService<Pot, Long, PotRepository> {

}
