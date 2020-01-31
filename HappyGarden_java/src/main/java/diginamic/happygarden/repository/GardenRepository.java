package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Garden;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long>{

}
