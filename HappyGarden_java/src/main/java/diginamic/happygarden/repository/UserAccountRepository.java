package diginamic.happygarden.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRight;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	public List<UserRight> findAllByFirstNameIgnoreCase(String name);
	
	public List<UserRight> findByLastNameIgnoreCase(String name);
	
	public Optional<UserRight> findByPseudonyme(String name);
}
