package diginamic.happygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	@Query("select m from Conversation c join c.messages m where c.id = :id")
	public List<Message> findByIdConversation(Long id);
}
