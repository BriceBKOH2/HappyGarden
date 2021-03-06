package diginamic.happygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	@Query("select m from Message m join m.conversation c where c.id = :id")
	public List<Message> findByIdConversation(Long id);
	
	@Query("select count(m) from Message m join m.conversation c where c.id = :convId")
	public Long countMessagesByConvId(Long convId);
	
//	@Query("insert into Message m (m.author, m.content) VALUES (message.author, message.content)")
//	public Message SaveMessageAndInsertIntoConversation(Message message);
}
