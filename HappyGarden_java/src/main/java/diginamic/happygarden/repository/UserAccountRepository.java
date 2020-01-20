package diginamic.happygarden.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	public List<UserAccount> findAllByFirstNameIgnoreCase(String name);
	
	public List<UserAccount> findByLastNameIgnoreCase(String name);
	
	public Optional<UserAccount> findByPseudonyme(String name);
	
}
