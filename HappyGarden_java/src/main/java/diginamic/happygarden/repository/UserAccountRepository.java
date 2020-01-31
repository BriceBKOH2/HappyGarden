package diginamic.happygarden.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	public List<UserAccount> findAllByFirstNameIgnoreCase(String name);
	
	public List<UserAccount> findByLastNameIgnoreCase(String name);
	
	public Optional<UserAccount> findByPseudonyme(String name);
	
	/**
	 * 
	 * @param id
	 * @return UserAccount with all objects fetched from database
	 */
	@Query("select distinct u from UserAccount u left join fetch u.gardens left join fetch u.userRole left join fetch u.favoritePlants where u.id = :id")
	public Optional<UserAccount> findByIdFetchAll(Long id);
}
