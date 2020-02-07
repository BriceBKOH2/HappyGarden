package diginamic.happygarden.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Garden;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long>{
	
	@Query("select g from Garden g join fetch g.user u where g.id = :id")
	public Optional<Garden> findByIdFetchUser(Long id);
}
