package diginamic.happygarden.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import diginamic.happygarden.model.UserRight;

public interface UserRightRepository extends JpaRepository<UserRight, Long> {

	public Optional<UserRight> findByName(String name);
}
