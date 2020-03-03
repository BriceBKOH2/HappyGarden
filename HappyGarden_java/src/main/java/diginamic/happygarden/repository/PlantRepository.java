package diginamic.happygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long>{
	
	@Query("SELECT DISTINCT p FROM Plant p WHERE TYPE(p) = Plant")
	public List<Plant> findAll();
	
	public List<Plant> findByCommonNameOrScientificName(String commonName, String scientificName);
	 
	@Query("select distinct p from Plant p where (lower(p.commonName) like lower(concat('%', :commonName, '%')) or lower(p.scientificName) like lower(concat('%', :scientificName, '%'))) and type(p) = Plant")
	public List<Plant> findByCommonNameIgnoreCaseContainsOrScientificNameIgnoreCaseContains(String commonName, String scientificName);
	
	public List<Plant> findByScientificNameIgnoreCase(String scientificName);
}
