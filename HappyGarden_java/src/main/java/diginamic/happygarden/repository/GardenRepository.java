package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diginamic.happygarden.model.Garden;

public interface GardenRepository extends JpaRepository<Garden, Long>{

}
