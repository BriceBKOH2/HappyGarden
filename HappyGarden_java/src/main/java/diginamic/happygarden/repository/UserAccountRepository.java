package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
}
