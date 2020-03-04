package diginamic.happygarden.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Garden;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long>{
	
	@Query("select g from Garden g join fetch g.user u where g.id = :id")
	public Optional<Garden> findByIdFetchUser(Long id);

	@Query("select g from Garden g join fetch g.user u where g.user.id = :userId")
	public List<Garden> findByUserIdOrderByNameAsc(Long userId);
	
	@Query("select count(g) from Garden g join g.user u where u.id = :userId")
	public Long countByUserId(Long userId);
}
