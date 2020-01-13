package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diginamic.happygarden.model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {

}
