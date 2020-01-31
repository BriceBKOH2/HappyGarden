package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long>{

}
