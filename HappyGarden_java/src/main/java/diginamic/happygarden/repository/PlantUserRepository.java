package diginamic.happygarden.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.model.PlantUser;

@Repository
public interface PlantUserRepository extends JpaRepository<PlantUser, Long>{
	public List<Plant> findByCommonNameOrScientificName(String commonName, String scientificName);
}
