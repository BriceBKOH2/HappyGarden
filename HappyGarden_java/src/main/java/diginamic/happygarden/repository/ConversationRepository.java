package diginamic.happygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long>{

	@Query("select c from Conversation c join c.users u where u.id = :userId")
	public List<Conversation> findAllByUserId(Long userId);
	
	@Query("select count(c) from UserAccount u join u.conversations c where u.id = :userId")
	public Long countByUserId(Long userId);

//	@Query("select u from UserAccount u join u.conversations c where c.id = :convId")
//	public List<UserAccount> findAllUserAccountbyConversationId(Long convId);
}
