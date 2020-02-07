package diginamic.happygarden.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	public List<UserAccount> findAllByFirstnameIgnoreCase(String name);
	
	public List<UserAccount> findByLastnameIgnoreCase(String name);
	
	public Optional<UserAccount> findByNickname(String name);
	
	/**
	 * 
	 * @param id
	 * @return UserAccount with all objects fetched from database
	 */
	@Query("select distinct u from UserAccount u left join fetch u.gardens left join fetch u.userRole left join fetch u.favoritePlants where u.id = :id")
	public Optional<UserAccount> findByIdFetchAll(Long id);
}
