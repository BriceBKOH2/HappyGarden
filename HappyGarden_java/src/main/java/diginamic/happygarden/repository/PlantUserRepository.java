package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.PlantUser;

@Repository
public interface PlantUserRepository extends JpaRepository<PlantUser, Long>{

}
