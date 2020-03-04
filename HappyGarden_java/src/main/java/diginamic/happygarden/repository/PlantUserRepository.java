package diginamic.happygarden.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Plant;
import diginamic.happygarden.model.PlantUser;

@Repository
public interface PlantUserRepository extends JpaRepository<PlantUser, Long>{
	
	@Query("select distinct p from Plant p where (lower(p.commonName) like lower(concat('%', :commonName, '%')) or lower(p.scientificName) like lower(concat('%', :scientificName, '%'))) and p.creator = :creator and type(p) = PlantUser")
	public List<Plant> findByCommonNameIgnoreCaseContainsOrScientificNameIgnoreCaseContains(String commonName, String scientificName, String creator);
	
	public List<Plant> findByCreator(String creator);
	
	
}
