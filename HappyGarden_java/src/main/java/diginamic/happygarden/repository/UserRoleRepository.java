package diginamic.happygarden.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import diginamic.happygarden.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	public Optional<UserRole> findByName(String name);
}
