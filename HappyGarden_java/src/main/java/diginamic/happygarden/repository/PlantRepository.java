package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

}
