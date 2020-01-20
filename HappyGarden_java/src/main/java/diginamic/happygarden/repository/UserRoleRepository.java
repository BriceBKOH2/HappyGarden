package diginamic.happygarden.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	@Query("select r from UserRole r left join fetch r.userRights where r.name = :name")
	public Optional<UserRole> findByName(String name);
}
