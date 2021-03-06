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
	
	public List<UserAccount> findByFirstnameIgnoreCaseContainsOrLastnameIgnoreCaseContainsOrNicknameIgnoreCaseContains(String firstname, String lastname, String nickname);
	
	/**
	 * 
	 * @param id
	 * @return UserAccount with all objects fetched from database
	 */
	@Query("SELECT DISTINCT u FROM UserAccount u LEFT JOIN FETCH u.gardens LEFT JOIN FETCH u.userRole LEFT JOIN FETCH u.favoritePlants WHERE u.id = :id")
	public Optional<UserAccount> findByIdFetchAll(Long id);
	
	@Query("select count(f) from UserAccount u join u.friends f where u.id = :userId")
	public Long countFriendsByUserId(Long userId);
	
	@Query("select fu from UserAccount u join u.friends f join UserAccount fu on fu.nickname = f where u.id = :userId")
	public List<UserAccount> findAllFriendsByUserId(Long userId);
}
