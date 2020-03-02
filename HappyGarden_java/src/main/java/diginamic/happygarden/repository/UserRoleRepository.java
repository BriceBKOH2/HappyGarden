package diginamic.happygarden.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	@Query("SELECT r from UserRole r LEFT JOIN FETCH r.userRights WHERE r.name = :name")
	public Optional<UserRole> findByName(String name);

	@Query("SELECT r from UserRole r WHERE r.name = :role")
	public Optional<UserRole> getDefaultRole(String role);
}
